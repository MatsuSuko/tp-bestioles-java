package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deletePersonWithoutAnimals() {
        entityManager.createQuery("DELETE FROM Person p WHERE NOT EXISTS (SELECT a FROM Animal a WHERE a.person = p)")
                .executeUpdate();
    }

    private final String[] FIRST_NAMES = {
            "Jean", "Marie", "Pierre", "Sophie", "Lucas", "Emma", "Thomas", "Louise",
            "Nicolas", "Julie", "Antoine", "Sarah", "Paul", "Claire", "David", "Laura"
    };

    private final String[] LAST_NAMES = {
            "Martin", "Bernard", "Dubois", "Thomas", "Robert", "Richard", "Petit",
            "Durand", "Leroy", "Moreau", "Simon", "Laurent", "Lefebvre", "Michel"
    };

    @Override
    public void generateRandomPeople(int count) {
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            Person person = new Person();

            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];

            int age = random.nextInt(63) + 18;

            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setAge(age);

            entityManager.persist(person);

            if (i % 50 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

}