package com.souvanny.demojpa.service;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.dal.AnimalRepository;
import com.souvanny.demojpa.exception.EntityToCreateHasAnIdException;
import com.souvanny.demojpa.exception.EntityToUpdateHasNoIdException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // Méthode Create
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    // Méthode Update
    public Animal updateAnimal(int id, Animal updatedAnimal) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            Animal existingAnimal = optionalAnimal.get();
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setColor(updatedAnimal.getColor());
            existingAnimal.setSex(updatedAnimal.getSex());
            existingAnimal.setSpecies(updatedAnimal.getSpecies());
            return animalRepository.save(existingAnimal);
        }
        throw new RuntimeException("Animal not found");
    }

    // Pagination
    public Page<Animal> findPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return animalRepository.findAll(pageable);
    }

    // Méthodes passe-plats
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> findAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> findAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public long countAnimalsBySex(String sex) {
        return animalRepository.countBySex(sex);
    }

    // Exeption
    public Animal create(Animal animal) {
        if (animal.getId() != 0) {
            throw new EntityToCreateHasAnIdException("L'entité à créer ne doit pas avoir d'ID.");
        }
        return animalRepository.save(animal);
    }

    public Animal update(Animal animal) {
        if (animal.getId() == 0) {
            throw new EntityToUpdateHasNoIdException("L'entité à mettre à jour doit avoir un ID.");
        }
        Optional<Animal> existingAnimal = animalRepository.findById(animal.getId());
        if (existingAnimal.isEmpty()) {
            throw new EntityNotFoundException("Animal avec l'ID " + animal.getId() + " non trouvé.");
        }
        return animalRepository.save(animal);
    }

    public void delete(int id) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal avec l'ID " + id + " non trouvé.");
        }
        animalRepository.deleteById(id);
    }
}
