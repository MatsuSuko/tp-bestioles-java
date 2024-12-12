package com.souvanny.demojpa.dal;

import com.souvanny.demojpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    /*Optional<Species> findFirstByCommonName(String commonName);

    List<Species> findByLatinNameContainingIgnoreCase(String partOfLatinName);*/

    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderByCommonNameAsc();

    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %:commonName%")
    List<Species> findByCommonNameLike(@Param("commonName") String commonName);
}
