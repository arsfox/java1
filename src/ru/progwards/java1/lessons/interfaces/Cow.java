package ru.progwards.java1.lessons.interfaces;

public class Cow extends Animal {

    public Cow(Double weight)
    {
        super(weight);
    }

    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    @Override
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
