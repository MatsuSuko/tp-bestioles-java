package com.souvanny.demojpa.service;

import com.souvanny.demojpa.dal.AnimalRepository;
import com.souvanny.demojpa.dto.AnimalDto;
import com.souvanny.demojpa.mapper.AnimalMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    public AnimalService(AnimalRepository animalRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
    }

    // Modifier la méthode findAll pour retourner des DTOs
    public List<AnimalDto> findAllAnimals() {
        return animalRepository.findAll().stream()
                .map(animalMapper::toDto)
                .collect(Collectors.toList());
    }

    // Ajouter une méthode pour la pagination avec DTOs
    public Page<AnimalDto> findPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return animalRepository.findAll(pageable)
                .map(animalMapper::toDto);
    }
}