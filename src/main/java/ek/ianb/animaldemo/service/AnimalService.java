package ek.ianb.animaldemo.service;

import ek.ianb.animaldemo.model.Animal;
import ek.ianb.animaldemo.model.Gender;
import ek.ianb.animaldemo.model.Species;
import ek.ianb.animaldemo.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals(Species species, Gender gender) {
        if(species == null && gender == null) {
            animalRepository.findAll();
        }
        return animalRepository.findByFilters(species, gender);
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
}
