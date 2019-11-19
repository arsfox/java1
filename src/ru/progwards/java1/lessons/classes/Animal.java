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
}
