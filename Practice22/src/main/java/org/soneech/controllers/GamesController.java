package org.soneech.controllers;

import org.soneech.models.Game;
import org.soneech.service.AuthorService;
import org.soneech.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/games")
public class GamesController {
    private final GameService gameService;
    private final AuthorService authorService;

    @Autowired
    public GamesController(GameService gameService, AuthorService authorService) {
        this.gameService = gameService;
        this.authorService = authorService;
    }

    @GetMapping
    public String games(Model model) {
        List<Game> games = gameService.getGames();
        model.addAttribute("games", games);
        return "games/games";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("game", game);
        return "games/show";
    }

    @GetMapping("/ordered-name")
    public String orderedGamesByName(Model model) {
        List<Game> games = gameService.orderedGamesByName();
        model.addAttribute("games", games);
        return "games/games";
    }

    @GetMapping("/ordered-creation-date")
    public String orderedGamesByCreationDate(Model model) {
        List<Game> games = gameService.orderedGamesByCreationDate();
        model.addAttribute("games", games);
        return "games/games";
    }

    @GetMapping("/new/{authorId}")
    public String newGamePage(@PathVariable("authorId") Long authorId, @ModelAttribute("game") Game game) {
        return "games/new";
    }

    @PostMapping("/new/{authorId}")
    public String create(@PathVariable("authorId") Long authorId, @ModelAttribute("game") Game game) {
        game.setGameAuthor(authorService.getAuthorById(authorId));
        gameService.addGame(game);
        return "redirect:/games";
    }

    @DeleteMapping("/{id}")
    public String deleteGame(@PathVariable("id") Long id) {
        gameService.deleteGame(gameService.getGameById(id));
        return "redirect:/games";
    }

    @GetMapping("/{id}/edit")
    public String updatePage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("game", gameService.getGameById(id));
        return "games/update";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("game") Game game) {
        gameService.updateGame(id, game);
        return "redirect:/games";
    }
}
