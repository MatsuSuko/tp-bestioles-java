package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(Species species);

    List<Animal> findByColorIn(List<String> colors);
}
