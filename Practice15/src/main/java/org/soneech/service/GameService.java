package org.soneech.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.soneech.models.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public void addGame(Game game) {
        session.beginTransaction();
        session.persist(game);
        session.getTransaction().commit();
    }
}
