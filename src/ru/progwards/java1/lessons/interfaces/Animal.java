package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

/**
 * Created by Arseniy on 18.11.2019.
 */
public class Animal implements FoodCompare, Comparable<Animal>{

    public double weight;

    public enum AnimalKind {
        ANIMAL, COW, HAMSTER, DUCK
    }
    public enum FoodKind {
        UNKNOWN, HAY, CORN
    }

    public Animal(double weight) {
        this.weight = weight;
    }

    public AnimalKind getKind(){
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    @Override
    public String toString() {
        return "I am <"+ getKind().toString() +">, eat <"+ getFoodKind().toString() +"> <"+calculateFoodWeight()+">";
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02d;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.weight, weight) == 0;
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()){
            case HAY: return 20;
            case CORN: return 50;
            default: return 0;
        }
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(getWeight(), animal.getWeight());
    }

    @Override
    public int compareTo(Animal animal) {
        if (getWeight() < animal.getWeight()) {
            return -1;
        }
        else if (getWeight() > animal.getWeight()){
            return 1;
        }
        else {
            return 0;
        }
    }



}
