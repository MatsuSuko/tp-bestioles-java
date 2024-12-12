package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    /*List<Animal> findBySpecies(Species species);

    List<Animal> findByColorIn(List<String> colors);*/

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    long countBySex(@Param("sex") String sex);
}
