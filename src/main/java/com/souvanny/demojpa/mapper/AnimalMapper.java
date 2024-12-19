package com.souvanny.demojpa.mapper;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.bo.Person;
import com.souvanny.demojpa.dto.AnimalDto;
import com.souvanny.demojpa.dal.PersonRepository;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class AnimalMapper {
    private final PersonRepository personRepository;

    public AnimalMapper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public AnimalDto toDto(Animal animal) {
        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        dto.setSpecies(animal.getSpecies().getCommonName());
        dto.setColor(animal.getColor());

        // Rechercher toutes les personnes qui ont cet animal
        String persons = personRepository.findAll().stream()
                .filter(person -> person.getAnimals().contains(animal))
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.joining(", "));
        dto.setPersons(persons);

        return dto;
    }
}