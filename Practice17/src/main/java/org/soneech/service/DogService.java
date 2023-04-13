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
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DogService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<Dog> dogCriteriaQuery;
    private Root<Dog> root;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        dogCriteriaQuery = criteriaBuilder.createQuery(Dog.class);
        root = dogCriteriaQuery.from(Dog.class);
    }

    public List<Dog> getDogs() {
        return session.createQuery("select d from Dog d", Dog.class).getResultList();
    }

    public Dog getDogById(int id) {
        return session.get(Dog.class, id);
    }

    public List<Dog> orderedDogsByBreed() {
        dogCriteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("breed")));
        Query<Dog> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void destroy() {
        session.close();
    }
}
