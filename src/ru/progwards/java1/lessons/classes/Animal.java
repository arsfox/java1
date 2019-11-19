package ru.progwards.java1.lessons.classes;

/**
 * Created by Arseniy on 18.11.2019.
 */
public class Animal {

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

    public String toString() {
        return "I am <"+ getKind() +">, eat <"+ getFoodKind() +"> <"+calculateFoodWeight()+">";
    }

    public double getWeight() {
        return 1d;
    }

    public double getFoodCoeff() {
        return 0.02d;
    }

    public double calculateFoodWeight() {
        return weight * getFoodCoeff();
    }
}
