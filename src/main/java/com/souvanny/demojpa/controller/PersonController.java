package com.souvanny.demojpa.controller;

import com.souvanny.demojpa.dto.PersonDto;
import com.souvanny.demojpa.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Modifier le endpoint findAll
    @GetMapping
    public ResponseEntity<List<PersonDto>> findAllPersons() {
        return ResponseEntity.ok(personService.findAllPersons());
    }
}