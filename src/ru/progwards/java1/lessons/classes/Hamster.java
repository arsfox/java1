package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal {

    public Hamster()
    {
        super(0.03d);
    }

    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    public double getFoodCoeff() {
        return 0.03d;
    }

    public double getWeight() {
        return weight;
    }
}
