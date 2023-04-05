package org.soneech.dao;

import org.soneech.models.Game;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameDAO {
    private List<Game> games;
    private static int count = 0;

    public GameDAO() {
        games = new ArrayList<>();
        games.add(new Game(count++, "TES III: Morrowind", "02.05.2002"));
        games.add(new Game(count++, "TES IV: Oblivion", "20.03.2006"));
        games.add(new Game(count++, "TES V: Skyrim", "11.11.2011"));
    }

    public List<Game> index() {
        return games;
    }

    public Game show(int id) {
        return games.stream().filter(game -> game.getId() == id).findAny().orElse(null);
    }

    public void save(Game game) {
        game.setId(count++);
        games.add(game);
    }

    public void delete(int id) {
        games.removeIf(game -> game.getId() == id);
    }
}


