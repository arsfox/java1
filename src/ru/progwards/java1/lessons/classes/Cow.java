package ru.progwards.java1.lessons.classes;

public class Cow extends Animal {

    public Cow()
    {
        super(0.05d);
    }

    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    public double getFoodCoeff() {
        return 0.05d;
    }

    public double getWeight() {
        return weight;
    }
}
