package org.soneech.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.soneech.models.GameAuthor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public List<GameAuthor> getAuthors() {
        return session.createQuery("select a from GameAuthor a", GameAuthor.class).getResultList();
    }

    public void addAuthor(GameAuthor author) {
        session.beginTransaction();
        session.persist(author);
        session.getTransaction().commit();
    }
}
