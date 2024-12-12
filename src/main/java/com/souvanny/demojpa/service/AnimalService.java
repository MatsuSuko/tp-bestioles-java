package com.souvanny.demojpa.service;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.dal.AnimalRepository;
import org.springframework.stereotype.Service;

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
}
