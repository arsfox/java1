package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    private float weight = 0.0f;
    protected void setWeight(float weight) {
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    Apple() {
        setWeight(1.0f);
    }
}

class Orange extends Fruit {
    Orange() {
        setWeight(1.0f);
    }
}

public class FruitBox<T extends Fruit> {
    private List<T> box = new ArrayList<>();

    public void add(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (T fruit : box){
            boxWeight += fruit.getWeight();
        }
        return boxWeight;
    }

    public List<T> getBox(){
        return box;
    }

    public void moveTo(FruitBox box) {
        List<T> feeder = box.getBox();
        for (T fruit : feeder){
            try {
                this.box.add(fruit);
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
    }
}

class Maimm {
    public static void main(String[] args) {
        FruitBox<Apple> boxApple = new FruitBox<>();
        boxApple.add(new Apple());
        boxApple.add(new Apple());
        boxApple.add(new Apple());
        System.out.println(boxApple.getWeight());

        FruitBox<Apple> boxAppleTwo = new FruitBox<>();
        System.out.println(boxAppleTwo.getWeight());
        boxAppleTwo.moveTo(boxApple);
        System.out.println(boxAppleTwo.getWeight());
    }
}




