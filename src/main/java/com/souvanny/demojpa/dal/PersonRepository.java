package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByLastNameOrFirstName(String lastName, String firstName);

    List<Person> findByAgeGreaterThanEqual(int age);
}
