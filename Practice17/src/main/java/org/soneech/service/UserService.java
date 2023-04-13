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
import org.soneech.models.Dog;
import org.soneech.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<User> userCriteriaQuery;
    private Root<User> root;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        root = userCriteriaQuery.from(User.class);
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

    public List<User> orderedUsersByFirstName() {
        userCriteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("firstName")));
        Query<User> query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }

    public List<User> orderedUsersByLastName() {
        userCriteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("lastName")));
        Query<User> query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void destroy() {
        session.close();
    }
}
