package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    // Trouve la première espèce dont le nom commun est égal au paramètre fourni
    Optional<Species> findFirstByCommonName(String commonName);
    // Trouve toutes les espèces dont le nom latin contient le paramètre fourni (ignorant la casse)
    List<Species> findByLatinNameContainingIgnoreCase(String partOfLatinName);
}
