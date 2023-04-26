package org.soneech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String startPage() {
        return "index";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
