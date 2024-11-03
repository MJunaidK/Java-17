package com.abstractclass.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Animal animal = new Animal("animal", "big", 100);
        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStiff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Dog("Pug", "small", 20));

        animals.add(new Horse("Clydesdale", "large", 1000));

        for(Animal animal: animals){
            doAnimalStiff(animal);
            if(animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }

    }

    private static void doAnimalStiff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
    }
}
