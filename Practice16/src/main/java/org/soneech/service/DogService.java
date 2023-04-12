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
public class DogService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public List<Dog> getDogs() {
        return session.createQuery("select d from Dog d", Dog.class).getResultList();
    }

    public Dog getDogById(int id) {
        return session.get(Dog.class, id);
    }

    public User getOwnerById(int id) {
        return session.get(User.class, id);
    }

    @PreDestroy
    public void destroy() {
        session.close();
    }
}
