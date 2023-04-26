package org.soneech.controllers;

import lombok.extern.slf4j.Slf4j;
import org.soneech.models.User;
import org.soneech.service.RegistrationService;
import org.soneech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class RegistrationController {
    private final UserService userService;
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(UserService userService, RegistrationService registrationService) {
        this.userService = userService;
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user, Model model) {
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("error", "Passwords don't match!");
            return "registration";
        }
        if (!registrationService.addUser(user)) {
            model.addAttribute("error", "User with this username already exists!");
            return "registration";
        }
        return "redirect:/";
    }
}
