package com.souvanny.demojpa.dal;

public interface PersonRepositoryCustom {
    void deletePersonWithoutAnimals();

    void generateRandomPeople(int count);
}
