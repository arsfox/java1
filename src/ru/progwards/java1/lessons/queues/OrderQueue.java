package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

class Order {
    static int numBuffer = 1;
    private double sum;
    private int num;

    public Order(double sum) {
        this.sum = sum;
        this.num = numBuffer++;
    }

    public double getSum() {
        return this.sum;
    }

    public int getNum() {
        return this.num;
    }
}

public class OrderQueue {

    private ArrayDeque<Order> firstOrdersQueue = new ArrayDeque<>();
    private ArrayDeque<Order> secondOrdersQueue = new ArrayDeque<>();
    private ArrayDeque<Order> thirdOrdersQueue = new ArrayDeque<>();

    public void add(Order order) {
        if(order.getSum() <= 10_000){
            thirdOrdersQueue.offerLast(order);
        } else
        if((order.getSum() > 10_000)&&(order.getSum() <= 20_000)) {
            secondOrdersQueue.offerLast(order);
        } else
        if(order.getSum() > 20_000){
            firstOrdersQueue.offerLast(order);
        }
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


