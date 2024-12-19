package com.souvanny.demojpa;

import com.souvanny.demojpa.bo.Animal;
import com.souvanny.demojpa.bo.Person;
import com.souvanny.demojpa.bo.Species;
import com.souvanny.demojpa.dal.AnimalRepository;
import com.souvanny.demojpa.dal.PersonRepository;
import com.souvanny.demojpa.dal.SpeciesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SpeciesRepository speciesRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    // Repository de base TP3
    /*@Override
    public void run(String... args) throws Exception {
        // Lister toutes les espèces
        speciesRepository.findAll().forEach(System.out::println);

        // Ajouter un animal
        Species species = speciesRepository.findById(1).orElseThrow();
        Animal newAnimal = new Animal();
        newAnimal.setName("Calamar");
        newAnimal.setColor("Orange");
        newAnimal.setSex("M");
        newAnimal.setSpecies(species);
        animalRepository.save(newAnimal);

        // Lister tous les animaux
        animalRepository.findAll().forEach(System.out::println);

        // Associer un animal à une personne
        Person person = personRepository.findById(1).orElseThrow();
        person.getAnimals().add(newAnimal);
        personRepository.save(person);

        // Vérifier les animaux d'une personne
        personRepository.findById(1).ifPresent(p -> {
            System.out.println(p.getFirstname() + " possède :");
            p.getAnimals().forEach(System.out::println);
        });

        // Supprimer un animal
        animalRepository.delete(newAnimal);
        System.out.println("Animal supprimé !");
    }*/


    // Repository Species TP4
    /*@Override
    public void run(String... args) throws Exception {
        String commonNameToSearch = "Chat";
        Optional<Species> foundSpecies = speciesRepository.findFirstByCommonName(commonNameToSearch);
        if (foundSpecies.isPresent()) {
            System.out.println("Première espèce trouvée avec le nom commun '" + commonNameToSearch + "' : " + foundSpecies.get());
        } else {
            System.out.println("Aucune espèce trouvée avec le nom commun '" + commonNameToSearch + "'");
        }

        String latinNamePart = "lupus";
        List<Species> speciesList = speciesRepository.findByLatinNameContainingIgnoreCase(latinNamePart);
        if (!speciesList.isEmpty()) {
            System.out.println("Espèces trouvées avec '" + latinNamePart + "' dans le nom latin :");
            speciesList.forEach(System.out::println);
        } else {
            System.out.println("Aucune espèce trouvée avec '" + latinNamePart + "' dans le nom latin.");
        }
    }*/

    // Repository Person TP4
    /*@Override
    public void run(String... args) throws Exception {
        String lastNameToSearch = "Vintroi";
        String firstNameToSearch = "Jean";
        List<Person> personsByNameOrFirstName = personRepository.findByLastNameOrFirstName(lastNameToSearch, firstNameToSearch);
        if (!personsByNameOrFirstName.isEmpty()) {
            System.out.println("Personnes trouvées avec le nom '" + lastNameToSearch + "' ou le prénom '" + firstNameToSearch + "' :");
            personsByNameOrFirstName.forEach(System.out::println);
        } else {
            System.out.println("Aucune personne trouvée avec le nom '" + lastNameToSearch + "' ou le prénom '" + firstNameToSearch + "'");
        }

        int ageToSearch = 33;
        List<Person> personsByAge = personRepository.findByAgeGreaterThanEqual(ageToSearch);
        if (!personsByAge.isEmpty()) {
            System.out.println("Personnes trouvées avec un âge supérieur ou égal à " + ageToSearch + " :");
            personsByAge.forEach(System.out::println);
        } else {
            System.out.println("Aucune personne trouvée avec un âge supérieur ou égal à " + ageToSearch);
        }
    }*/

    /*// Repository Animal TP4
    @Override
    public void run(String... args) throws Exception {
        int speciesId = 1;
        Optional<Species> foundSpecies = speciesRepository.findById(speciesId);
        if (foundSpecies.isPresent()) {
            List<Animal> animalsBySpecies = animalRepository.findBySpecies(foundSpecies.get());
            System.out.println("Animaux de l'espèce " + foundSpecies.get().getCommonName() + " :");
            animalsBySpecies.forEach(System.out::println);
        } else {
            System.out.println("Aucune espèce trouvée avec l'ID " + speciesId);
        }

        List<String> colors = List.of("Gris", "Noir", "Blanc");
        List<Animal> animalsByColors = animalRepository.findByColorIn(colors);
        System.out.println("Animaux avec une couleur parmi " + colors + " :");
        animalsByColors.forEach(System.out::println);
    }*/


    /*// Repository Species TP5
    @Override
    public void run(String... args) throws Exception {
        // Récupérer et afficher toutes les espèces triées par nom commun ascendant
        System.out.println("Espèces triées par nom commun (ascendant) :");
        List<Species> speciesListOrdered = speciesRepository.findAllOrderByCommonNameAsc();
        speciesListOrdered.forEach(System.out::println);

        // Rechercher des espèces avec un nom commun contenant un mot spécifique
        System.out.println("\nEspèces avec un nom commun contenant 'lion' :");
        List<Species> speciesWithLion = speciesRepository.findByCommonNameLike("lion");
        speciesWithLion.forEach(System.out::println);
    }*/

    // Repository Person TP5
    /*@Override
    public void run(String... args) throws Exception {
        int ageMin = 25;
        int ageMax = 40;
        List<Person> personsByAgeRange = personRepository.findByAgeBetween(ageMin, ageMax);

        System.out.println("Personnes dont l'âge est entre " + ageMin + " et " + ageMax + " :");
        personsByAgeRange.forEach(System.out::println);
    }*/

    // Repository Animal TP5
    /*@Override
    public void run(String... args) throws Exception {
        String sexToCount = "M";
        long countMaleAnimals = animalRepository.countBySex(sexToCount);
        System.out.println("Nombre d'animaux de sexe '" + sexToCount + "' : " + countMaleAnimals);

        String sexToCountF = "F";
        long countFemaleAnimals = animalRepository.countBySex(sexToCountF);
        System.out.println("Nombre d'animaux de sexe '" + sexToCountF + "' : " + countFemaleAnimals);
    }*/


    // Repository Person "ajout méthode pour supprimer person qui n'ont pas d'animaux" TP6
    /*@Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Nombre de personnes avant la suppression : " + personRepository.count());

        System.out.println("\nListe des personnes et leurs animaux avant la suppression :");
        personRepository.findAll().forEach(person -> {
            System.out.println(person.getFirstName() + " " + person.getLastName() +
                    " - Nombre d'animaux : " + person.getAnimals().size());
        });

        personRepository.deletePersonWithoutAnimals();
        System.out.println("\nLes personnes sans animaux ont été supprimées.");

        System.out.println("Nombre de personnes après la suppression : " + personRepository.count());

        System.out.println("\nListe des personnes restantes :");
        personRepository.findAll().forEach(person -> {
            System.out.println(person.getFirstName() + " " + person.getLastName() +
                    " - Nombre d'animaux : " + person.getAnimals().size());
        });
    }*/

    // Repository Person "ajout méthode pour créer person random" TP6
    /*@Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Nombre de personnes avant la génération : " + personRepository.count());

        personRepository.generateRandomPeople(3);

        System.out.println("Nombre de personnes après la génération : " + personRepository.count());

        System.out.println("\nListe des personnes générées :");
        personRepository.findAll().forEach(person -> {
            System.out.println(person.getFirstName() + " " + person.getLastName() +
                    " - Age : " + person.getAge());
        });
    }*/

}
