package org.soneech.controllers;

import org.soneech.models.GameAuthor;
import org.soneech.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorsController {
    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String authors(Model model) {
        List<GameAuthor> authors = authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "authors/authors";
    }

    @GetMapping("/new")
    public String newAuthorPage(@ModelAttribute("author") GameAuthor author) {
        return "authors/new";
    }

    @PostMapping
    public String create(@ModelAttribute("author") GameAuthor author) {
        authorService.addAuthor(author);
        return "redirect:/authors";
    }
}
