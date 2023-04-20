package org.soneech.controllers;

import org.soneech.models.GameAuthor;
import org.soneech.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/json")
    @ResponseBody
    public List<GameAuthor> authorsJson() {
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        GameAuthor author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "authors/show";
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

    @GetMapping("/ordered-nickname")
    public String orderedAuthorsByNickname(Model model) {
        List<GameAuthor> authors = authorService.orderedAuthorsByNickname();
        model.addAttribute("authors", authors);
        return "authors/authors";
    }

    @GetMapping("/ordered-birth-date")
    public String orderedAuthorsByBirthDate(Model model) {
        List<GameAuthor> authors = authorService.orderedAuthorsByBirthDate();
        model.addAttribute("authors", authors);
        return "authors/authors";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable("id") int id) {
        authorService.deleteAuthor(authorService.getAuthorById(id));
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "authors/update";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("author") GameAuthor author) {
        authorService.updateAuthor(id, author);
        return "redirect:/authors";
    }
}
