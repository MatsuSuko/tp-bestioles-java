package com.souvanny.demojpa.controller;

import com.souvanny.demojpa.dto.AnimalDto;
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

    // Modifier le endpoint findAll
    @GetMapping
    public ResponseEntity<List<AnimalDto>> findAllAnimals() {
        return ResponseEntity.ok(animalService.findAllAnimals());
    }

    // Modifier le endpoint de pagination
    @GetMapping("/page")
    public ResponseEntity<Page<AnimalDto>> findPage(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        return ResponseEntity.ok(animalService.findPage(pageNumber, pageSize));
    }
}