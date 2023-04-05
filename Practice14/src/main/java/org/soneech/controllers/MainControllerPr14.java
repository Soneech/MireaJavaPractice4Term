package org.soneech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllerPr14 {
    @GetMapping
    public String mainPage() {
        return "index";
    }
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
