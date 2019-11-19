package ru.progwards.java1.lessons.ru.progwards.java1.lessons.classes;

public class Hamster extends Animal {

    public Hamster(double weight) {
        super(weight);
    }

    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.03d;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
