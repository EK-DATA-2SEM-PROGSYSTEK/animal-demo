package ek.ianb.animaldemo.repository;

import ek.ianb.animaldemo.model.Gender;
import ek.ianb.animaldemo.model.Species;
import org.springframework.stereotype.Repository;
import ek.ianb.animaldemo.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository  {
    private final List<Animal> animals = new ArrayList<>();
    private long nextId = 1;

    public AnimalRepository() {
        populate();
    }

    public Animal save(Animal animal) {
        animal.setId(nextId++);
        animals.add(animal);
        return animal;
    }

    public List<Animal> findAll() {
        return new ArrayList<>(animals);
    }

    public Animal findById(long id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public List<Animal> findByFilters(Species species, Gender gender) {
        List<Animal> foundAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            boolean matchesSpecies = (species == null) || (animal.getSpecies() == species);
            boolean matchesGender  = (gender == null)  || (animal.getGender() == gender);

            if (matchesSpecies && matchesGender) {
                foundAnimals.add(animal);
            }
        }

        return foundAnimals;
    }

    private void populate() {
        save(new Animal("Max", Species.DOG, Gender.MALE));
        save(new Animal("Luna", Species.CAT, Gender.FEMALE));
        save(new Animal("Mille", Species.CAT, Gender.FEMALE));
        save(new Animal("Bamse", Species.RABBIT, Gender.MALE));
        save(new Animal("Nuser", Species.RABBIT, Gender.UNKNOWN));
        save(new Animal("Pjuske", Species.BIRD, Gender.FEMALE));
        save(new Animal("Kvik", Species.RODENT, Gender.MALE));
        save(new Animal("Freja", Species.DOG, Gender.FEMALE));
        save(new Animal("Simba", Species.CAT, Gender.MALE));
    }
}
