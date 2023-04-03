package org.soneech.controllers;

import org.soneech.configuration.HashAppConfiguration;
import org.soneech.models.FileData;
import org.soneech.service.FileHashService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HashAppConfiguration.class);
    @GetMapping("/")
    public String hashPage(Model model) {
        model.addAttribute("fileData", new FileData());
        return "hash";
    }


    @PostMapping("/")
    public String getFileData(@ModelAttribute("fileData") FileData fileData, Model model) {
        FileHashService fileHashService = context.getBean(FileHashService.class);
        String message = fileHashService.hashingFile(fileData.getInputFileName(), fileData.getOutputFileName());
        model.addAttribute("message", message);
        return "hash";
    }
}
