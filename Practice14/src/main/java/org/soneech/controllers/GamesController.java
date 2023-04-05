package org.soneech.controllers;

import org.soneech.dao.GameDAO;
import org.soneech.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GamesController {
    private GameDAO gameDAO;

    @Autowired
    public GamesController(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @GetMapping
    public String games(Model model) {
        model.addAttribute("games", gameDAO.index());
        return "games/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("game", gameDAO.show(id));
        return "games/show";
    }

    @GetMapping("/new")
    public String newGamePage(@ModelAttribute("game") Game game) {
        return "games/new";
    }

    @PostMapping
    public String createGame(@ModelAttribute("game") Game game) {
        gameDAO.save(game);
        return "redirect:/games";
    }

    @DeleteMapping("/{id}")
    public String deleteGame(@PathVariable("id") int id) {
        gameDAO.delete(id);
        return "redirect:/games";
    }
}
