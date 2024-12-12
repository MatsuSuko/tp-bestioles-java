package com.souvanny.demojpa.dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deletePersonWithoutAnimals() {
        entityManager.createQuery("DELETE FROM Person p WHERE NOT EXISTS (SELECT a FROM Animal a WHERE a.person = p)")
                .executeUpdate();
    }

}