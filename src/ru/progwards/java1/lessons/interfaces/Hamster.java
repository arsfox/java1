package ru.progwards.java1.lessons.interfaces;

public class Hamster extends Animal {

    public Hamster(Double weight)
    {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    @Override
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
