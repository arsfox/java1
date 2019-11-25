package ru.progwards.java1.lessons.interfaces;

public class Duck extends Animal {

    public Duck()
    {
        super(0.04d);
    }

    @Override
    public AnimalKind getKind(){
        return AnimalKind.DUCK;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.04d;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
