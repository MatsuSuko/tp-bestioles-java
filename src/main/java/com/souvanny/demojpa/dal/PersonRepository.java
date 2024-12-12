package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.bo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*public interface PersonRepository extends JpaRepository<Person, Integer> {*/
public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {
    /*List<Person> findByLastNameOrFirstName(String lastName, String firstName);

    List<Person> findByAgeGreaterThanEqual(int age);*/

    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
    List<Person> findByAgeBetween(@Param("ageMin") int ageMin, @Param("ageMax") int ageMax);
}
