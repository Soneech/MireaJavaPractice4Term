package org.soneech.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.soneech.models.Game;
import org.soneech.models.GameAuthor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public List<Game> getGames() {
        return session.createQuery("select g from Game g", Game.class).getResultList();
    }

    public Game getGameById(int id) {
        return session.get(Game.class, id);
    }

    public GameAuthor getAuthorById(int id) {
        return session.get(GameAuthor.class, id);
    }

    @PreDestroy
    public void destroy() {
        session.close();
    }
}
