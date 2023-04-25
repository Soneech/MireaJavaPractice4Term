package org.soneech.service;

import lombok.extern.slf4j.Slf4j;
import org.soneech.models.Game;
import org.soneech.models.GameAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
@ManagedResource
public class SchedulerFileService {
    private GameService gameService;
    private AuthorService authorService;
    private final String filesDir = "Practice22/src/main/resources/backups/";

    @Autowired
    public SchedulerFileService(GameService gameService, AuthorService authorService) {
        this.gameService = gameService;
        this.authorService = authorService;
    }

    public boolean clearDirectory() {
        log.info("Started cleaning directory");
        try {
            File dir = ResourceUtils.getFile(filesDir);
            for (File file: dir.listFiles()) {
                if (file.exists()) {
                    file.delete();
                    log.info("File {} deleted", file.getName());
                }
            }
            log.info("All files deleted");
            return true;
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            log.info("Oops... something went wrong...");
            return false;
        }
    }

    @ManagedOperation(description = "Clear backup directory, create .txt files with data from DB")
    @Scheduled(cron = "0 * * * * *")  // called every minute
    //@Scheduled(cron = "0 */30 * * * *")
    public void backupFromDataBase() {
        if (clearDirectory()) {
            try {
                log.info("Started writing data from DB");
                FileWriter fileWriter = new FileWriter(filesDir + "games.txt");
                for (Game game: gameService.getGames()) {
                    fileWriter.write(game.toString());
                    fileWriter.write("\n");
                }
                fileWriter.close();

                fileWriter = new FileWriter(filesDir + "game_authors.txt");
                for (GameAuthor author: authorService.getAuthors()) {
                    fileWriter.write(author.toString());
                    fileWriter.write("\n");
                }

                fileWriter.close();
                log.info("Finished writing data from DB");
            } catch (IOException exception) {
                exception.printStackTrace();
                log.info("Oops... something went wrong...");
            }
        }
    }
}
