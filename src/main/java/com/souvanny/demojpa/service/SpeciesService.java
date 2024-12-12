package com.souvanny.demojpa.service;

import com.souvanny.demojpa.bo.Species;
import com.souvanny.demojpa.dal.SpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {
    private final SpeciesRepository speciesRepository;

    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    // Méthode Create
    public Species createSpecies(Species species) {
        return speciesRepository.save(species);
    }

    // Méthode Update
    public Species updateSpecies(int id, Species updatedSpecies) {
        Optional<Species> optionalSpecies = speciesRepository.findById(id);
        if (optionalSpecies.isPresent()) {
            Species existingSpecies = optionalSpecies.get();
            existingSpecies.setCommonName(updatedSpecies.getCommonName());
            existingSpecies.setLatinName(updatedSpecies.getLatinName());
            return speciesRepository.save(existingSpecies);
        }
        throw new RuntimeException("Species not found");
    }

    // Méthodes passe-plats
    public void deleteSpecies(int id) {
        speciesRepository.deleteById(id);
    }

    public List<Species> findAllSpecies() {
        return speciesRepository.findAll();
    }

    public Optional<Species> findSpeciesById(int id) {
        return speciesRepository.findById(id);
    }

    public List<Species> findByCommonNameLike(String commonName) {
        return speciesRepository.findByCommonNameLike(commonName);
    }
}

