package ek.ianb.animaldemo.controller;

import ek.ianb.animaldemo.model.Animal;
import ek.ianb.animaldemo.model.Gender;
import ek.ianb.animaldemo.model.Species;
import ek.ianb.animaldemo.repository.AnimalRepository;
import ek.ianb.animaldemo.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAnimals(@RequestParam(required = false) Species species,
                                                   @RequestParam(required = false) Gender gender) {
        List<Animal> animals = animalService.getAnimals(species, gender);
        return ResponseEntity.ok(animals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
        Animal animal = animalService.getAnimalById(id);
        return animal == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(animal);
    }


    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.createAnimal(animal);
        return ResponseEntity.ok(createdAnimal);
    }










}
