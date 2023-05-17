package org.soneech.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.soneech.models.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<Game> gameCriteriaQuery;
    private Root<Game> root;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        gameCriteriaQuery = criteriaBuilder.createQuery(Game.class);
        root = gameCriteriaQuery.from(Game.class);
    }

    public List<Game> getGames() {
        return session.createQuery("select g from Game g", Game.class).getResultList();
    }

    public Game getGameById(int id) {
        return session.get(Game.class, id);
    }

    public List<Game> orderedGamesByName() {
        gameCriteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("name")));
        Query<Game> query = session.createQuery(gameCriteriaQuery);
        return query.getResultList();
    }

    public List<Game> orderedGamesByCreationDate() {
        gameCriteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("creationDate")));
        Query<Game> query = session.createQuery(gameCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void destroy() {
        session.close();
    }
}
