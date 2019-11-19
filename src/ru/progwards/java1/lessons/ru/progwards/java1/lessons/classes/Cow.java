package ru.progwards.java1.lessons.ru.progwards.java1.lessons.classes;

public class Cow extends Animal {

    public Cow(double weight) {
        super(weight);
    }

    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        return 0.05d;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
