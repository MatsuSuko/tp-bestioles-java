package com.souvanny.demojpa.service;

import com.souvanny.demojpa.dal.PersonRepository;
import com.souvanny.demojpa.dto.PersonDto;
import com.souvanny.demojpa.mapper.PersonMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    // Modifier la méthode findAll pour retourner des DTOs
    public List<PersonDto> findAllPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    // Ajouter une méthode pour la pagination avec DTOs
    public Page<PersonDto> findAllPersonsPaged(Pageable pageable) {
        return personRepository.findAll(pageable)
                .map(personMapper::toDto);
    }
}