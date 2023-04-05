package org.soneech.controllers;

import org.soneech.dao.GameAuthorDAO;
import org.soneech.dao.GameDAO;
import org.soneech.models.Game;
import org.soneech.models.GameAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorsController {
    private GameAuthorDAO gameAuthorDAO;

    @Autowired
    public AuthorsController(GameAuthorDAO gameAuthorDAO) {
        this.gameAuthorDAO = gameAuthorDAO;
    }

    @GetMapping
    public String authors(Model model) {
        model.addAttribute("authors", gameAuthorDAO.index());
        return "authors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", gameAuthorDAO.show(id));
        return "authors/show";
    }

    @GetMapping("/new")
    public String newAuthorPage(@ModelAttribute("author") GameAuthor author) {
        return "authors/new";
    }

    @PostMapping
    public String createAuthor(@ModelAttribute("author") GameAuthor author) {
        gameAuthorDAO.save(author);
        return "redirect:/authors";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable("id") int id) {
        gameAuthorDAO.delete(id);
        return "redirect:/authors";
    }
}
