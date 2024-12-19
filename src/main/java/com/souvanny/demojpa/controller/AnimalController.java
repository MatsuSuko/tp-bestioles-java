package com.souvanny.demojpa.controller;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.service.AnimalService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        return ResponseEntity.ok(animalService.createAnimal(animal));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        return ResponseEntity.ok(animalService.updateAnimal(id, updatedAnimal));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

    // FindAll
    @GetMapping
    public ResponseEntity<List<Animal>> findAllAnimals() {
        return ResponseEntity.ok(animalService.findAllAnimals());
    }

    // FindById
    @GetMapping("/{id}")
    public ResponseEntity<Animal> findAnimalById(@PathVariable int id) {
        return animalService.findAnimalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CountBySex
    @GetMapping("/count")
    public ResponseEntity<Long> countAnimalsBySex(@RequestParam String sex) {
        return ResponseEntity.ok(animalService.countAnimalsBySex(sex));
    }

    // Pagination
    @GetMapping("/page")
    public ResponseEntity<Page<Animal>> findPage(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        return ResponseEntity.ok(animalService.findPage(pageNumber, pageSize));
    }
}

