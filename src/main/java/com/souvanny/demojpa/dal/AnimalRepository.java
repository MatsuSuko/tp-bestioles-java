package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    // Requête pour récupérer tous les animaux d'une Species spécifique
    List<Animal> findBySpecies(Species species);

    // Requête pour récupérer tous les animaux dont la couleur est dans la liste fournie
    List<Animal> findByColorIn(List<String> colors);
}
