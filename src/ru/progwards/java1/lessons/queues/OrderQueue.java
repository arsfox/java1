package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

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

public class OrderQueue {

    ArrayDeque<Order> firstOrdersQueue = new ArrayDeque<>();
    ArrayDeque<Order> secondOrdersQueue = new ArrayDeque<>();
    ArrayDeque<Order> thirdOrdersQueue = new ArrayDeque<>();

    public void add(Order order) {

    }

    public Order get() {
        if(firstOrdersQueue.peekFirst() != null) {
            return firstOrdersQueue.pollFirst();
        } else
        if(secondOrdersQueue.peekFirst() != null) {
            return secondOrdersQueue.pollFirst();
        } else
        if(thirdOrdersQueue.peekFirst() != null){
            return thirdOrdersQueue.pollFirst();
        }
        return null;
    }
}

