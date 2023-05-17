package org.soneech.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.soneech.models.Game;
import org.soneech.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        log.info("Find all games");
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        log.info("Getting game by id");
        return gameRepository.findById(id).get();
    }

    public void addGame(Game game) {
        log.info("Adding game to DB with data from form");
        gameRepository.save(game);
    }

    public void deleteGame(Game game) {
        log.info("Deleting game from DB");
        gameRepository.delete(game);
    }

    public void updateGame(Long id, Game updatedGame) {
        log.info("Updating game with data from update form");
        Game game = getGameById(id);
        game.setName(updatedGame.getName());
        game.setCreationDate(updatedGame.getCreationDate());
        addGame(game);
    }

    public List<Game> orderedGamesByName() {
        log.info("Getting list of games, ordered by name");
        return gameRepository.findAll(Sort.by("name"));
    }

    public List<Game> orderedGamesByCreationDate() {
        log.info("Getting list of games, ordered by creation date");
        return gameRepository.findAll(Sort.by("creationDate"));
    }
}
