package com.souvanny.demojpa.service;

import com.souvanny.demojpa.bo.Person;
import com.souvanny.demojpa.dal.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Méthode Create
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // Méthode Update
    public Person updatePerson(int id, Person updatedPerson) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setFirstName(updatedPerson.getFirstName());
            existingPerson.setLastName(updatedPerson.getLastName());
            existingPerson.setAge(updatedPerson.getAge());
            return personRepository.save(existingPerson);
        }
        throw new RuntimeException("Person not found");
    }

    // Méthodes passe-plats
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonById(int id) {
        return personRepository.findById(id);
    }
}
