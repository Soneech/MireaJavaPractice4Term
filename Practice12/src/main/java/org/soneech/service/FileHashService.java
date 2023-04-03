package org.soneech.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileHashService {
    private final String PATH = "Practice12/src/main/resources/";
    private String inputFileName, outputFileName;
    private File fileInput, fileOutput;

    @PostConstruct
    private void init() {  // default values
        this.inputFileName = PATH + "input.txt";
        this.outputFileName = PATH + "output.txt";
    }

    public String hashingFile(String input, String output) {
        inputFileName = PATH + input;
        outputFileName = PATH + output;

        fileInput = new File(this.inputFileName);
        fileOutput = new File(this.outputFileName);

        try {
            BufferedWriter writer;

            if (fileInput.exists()) {
                writer = new BufferedWriter(new FileWriter(fileOutput));
                String fileContent = new String(Files.readAllBytes(Paths.get(inputFileName)));
                writer.write(DigestUtils.md5DigestAsHex(fileContent.getBytes()));
                writer.close();

                return "Hashing file successfully";
            }
            else {
                writer = new BufferedWriter(new FileWriter(fileOutput));
                writer.write("null");
                writer.close();

                return "Source file doesn't exist! Created output file with text: 'null'";
            }

        } catch (IOException exception) {
            exception.printStackTrace();
            return "Oops, something went wrong... Try again.";
        }
    }

    @PreDestroy
    private void destroy() {
        try {
            Files.delete(Paths.get(inputFileName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
