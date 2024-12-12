package com.souvanny.demojpa.controller;

import com.souvanny.demojpa.bo.Species;
import com.souvanny.demojpa.service.SpeciesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {
    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Species> createSpecies(@RequestBody Species species) {
        return ResponseEntity.ok(speciesService.createSpecies(species));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Species> updateSpecies(@PathVariable int id, @RequestBody Species updatedSpecies) {
        return ResponseEntity.ok(speciesService.updateSpecies(id, updatedSpecies));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable int id) {
        speciesService.deleteSpecies(id);
        return ResponseEntity.noContent().build();
    }

    // FindAll
    @GetMapping
    public ResponseEntity<List<Species>> findAllSpecies() {
        return ResponseEntity.ok(speciesService.findAllSpecies());
    }

    // FindById
    @GetMapping("/{id}")
    public ResponseEntity<Species> findSpeciesById(@PathVariable int id) {
        return speciesService.findSpeciesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // FindByCommonName
    @GetMapping("/search")
    public ResponseEntity<List<Species>> findByCommonNameLike(@RequestParam String commonName) {
        return ResponseEntity.ok(speciesService.findByCommonNameLike(commonName));
    }
}

