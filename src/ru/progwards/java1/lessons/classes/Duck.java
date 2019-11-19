package ru.progwards.java1.lessons.classes;

public class Duck extends Animal {

    public AnimalKind getKind(){
        return AnimalKind.DUCK;
    }

    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    public double getFoodCoeff() {
        return 0.04d;
    }

    public double getWeight() {
        return weight;
    }
}
