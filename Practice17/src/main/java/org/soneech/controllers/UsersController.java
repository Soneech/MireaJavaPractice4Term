package org.soneech.controllers;

import org.soneech.models.Dog;
import org.soneech.models.User;
import org.soneech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users/users";
    }

    @GetMapping("/json")
    @ResponseBody
    public List<User> usersJson() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/ordered-first-name")
    public String orderedUsersByFirstName(Model model) {
        List<User> users = userService.orderedUsersByFirstName();
        model.addAttribute("users", users);
        return "/users/users";
    }

    @GetMapping("/ordered-last-name")
    public String orderedUsersByLastName(Model model) {
        List<User> users = userService.orderedUsersByLastName();
        model.addAttribute("users", users);
        return "/users/users";
    }
}
