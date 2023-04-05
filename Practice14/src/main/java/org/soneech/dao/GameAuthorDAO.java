package org.soneech.dao;

import org.soneech.models.Game;
import org.soneech.models.GameAuthor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameAuthorDAO {
    private List<GameAuthor> gameAuthors;
    private static int count = 0;

    public GameAuthorDAO() {
        gameAuthors = new ArrayList<>();
        gameAuthors.add(new GameAuthor(count++, "Todd Andrew Howard", "25.05.1971"));

    }

    public List<GameAuthor> index() {
        return gameAuthors;
    }

    public GameAuthor show(int id) {
        return gameAuthors.stream().filter(author -> author.getId() == id).findAny().orElse(null);
    }

    public void save(GameAuthor author) {
        author.setId(count++);
        gameAuthors.add(author);
    }

    public void delete(int id) {
        gameAuthors.removeIf(author -> author.getId() == id);
    }
}
