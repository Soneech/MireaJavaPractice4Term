package org.soneech.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.soneech.models.Game;
import org.soneech.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(long id) {
        return gameRepository.findById(id);
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(long id) {
        gameRepository.deleteById(id);
    }

    public void updateGame(long id, Game updatedGame) {
        Game game = getGameById(id);
        game.setName(updatedGame.getName());
        game.setCreationDate(updatedGame.getCreationDate());
        addGame(game);
    }

    public List<Game> orderedGamesByName() {
        return gameRepository.findAll(Sort.by("name"));
    }

    public List<Game> orderedGamesByCreationDate() {
        return gameRepository.findAll(Sort.by("creationDate"));
    }
}
