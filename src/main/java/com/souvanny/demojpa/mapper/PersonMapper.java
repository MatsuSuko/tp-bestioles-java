package com.souvanny.demojpa.mapper;

import com.souvanny.demojpa.bo.Person;
import com.souvanny.demojpa.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDto toDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setName(person.getLastName().toUpperCase() + " " + person.getFirstName());
        dto.setAge(person.getAge());

        // Conversion des animaux en tableau de String
        String[] animalArray = person.getAnimals().stream()
                .map(animal -> animal.getName() + " (" + animal.getSpecies().getCommonName() + ")")
                .toArray(String[]::new);
        dto.setAnimals(animalArray);

        return dto;
    }
}