package ek.ianb.animaldemo.model;


public class Animal {
    private Long id;
    private String name;
    private Species species;
    private Gender gender;


    public Animal(String name, Species species, Gender gender) {
        this.name = name;
        this.species = species;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public Gender getGender() {
        return gender;
    }

}
