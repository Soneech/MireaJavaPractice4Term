package org.soneech.controllers;

import org.soneech.models.Game;
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

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("game", game);
        return "games/show";
    }
}
