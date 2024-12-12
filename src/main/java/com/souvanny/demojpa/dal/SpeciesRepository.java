package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    /*// Trouve la première espèce dont le nom commun est égal au paramètre fourni
    Optional<Species> findFirstByCommonName(String commonName);
    // Trouve toutes les espèces dont le nom latin contient le paramètre fourni (ignorant la casse)
    List<Species> findByLatinNameContainingIgnoreCase(String partOfLatinName);*/

    // Requête pour récupérer toutes les espèces, triées par nom commun en ordre ascendant
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderByCommonNameAsc();

    // Requête pour récupérer les espèces avec un nom commun LIKE le paramètre fourni
    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %:commonName%")
    List<Species> findByCommonNameLike(@Param("commonName") String commonName);
}
