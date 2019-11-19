package ru.progwards.java1.lessons.ru.progwards.java1.lessons.classes;

public class Duck extends Animal {

    public Duck(double weight) {
        super(weight);
    }

    public AnimalKind getKind(){
        return AnimalKind.DUCK;
    }

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
