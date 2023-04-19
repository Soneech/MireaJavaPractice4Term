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
import org.soneech.models.GameAuthor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<GameAuthor> authorCriteriaQuery;
    private Root<GameAuthor> root;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        authorCriteriaQuery = criteriaBuilder.createQuery(GameAuthor.class);
        root = authorCriteriaQuery.from(GameAuthor.class);
    }

    public List<GameAuthor> getAuthors() {
        return session.createQuery("select a from GameAuthor a", GameAuthor.class).getResultList();
    }

    public GameAuthor getAuthorById(int id) {
        return session.get(GameAuthor.class, id);
    }

    public void addAuthor(GameAuthor author) {
        session.beginTransaction();
        session.persist(author);
        session.getTransaction().commit();
    }

    public List<GameAuthor> orderedAuthorsByNickname() {
        authorCriteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("nickname")));
        Query<GameAuthor> query = session.createQuery(authorCriteriaQuery);
        return query.getResultList();
    }

    public List<GameAuthor> orderedAuthorsByBirthDate() {
        authorCriteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("birthDate")));
        Query<GameAuthor> query = session.createQuery(authorCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void destroy() {
        session.close();
    }
}
