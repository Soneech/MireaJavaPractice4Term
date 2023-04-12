package org.soneech.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.soneech.models.Dog;
import org.soneech.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public List<User> getUsers() {
        return session.createQuery("select u from User u", User.class).getResultList();
    }

    public User getUserById(int id) {
        return session.get(User.class, id);
    }

    public void addUser(User user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @PreDestroy
    public void destroy() {
        session.close();
    }
}
