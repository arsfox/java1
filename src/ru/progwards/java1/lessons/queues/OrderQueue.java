package ru.progwards.java1.lessons.queues;

public class OrderQueue {

    public void add(Order order) {

    }

    public Order get() {
        return new Order(1.0);
    }
}

class Order {
    private double sum;
    private int num;

    public Order(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return this.sum;
    }

    public int getNum() {
        return this.num;
    }
}
