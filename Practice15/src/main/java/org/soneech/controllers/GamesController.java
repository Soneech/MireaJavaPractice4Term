package org.soneech.controllers;

import org.soneech.models.Game;
import org.soneech.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/games")
public class GamesController {
    private final GameService gameService;

    @Autowired
    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String games(Model model) {
        List<Game> games = gameService.getGames();
        model.addAttribute("games", games);
        return "games/games";
    }

    @GetMapping("/new")
    public String newGamePage(@ModelAttribute("game") Game game) {
        return "games/new";
    }

    @PostMapping
    public String create(@ModelAttribute("game") Game game) {
        gameService.addGame(game);
        return "redirect:/games";
    }
}
