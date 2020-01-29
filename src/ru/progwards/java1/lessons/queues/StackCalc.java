package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {

    private ArrayDeque<Double> stack = new ArrayDeque<>();

    public void push(double value) {
        stack.offerFirst(value);
    }

    public double pop() {
        if(stack.peekFirst() != null) {
            return stack.pollFirst();
        }
    }

    public void add() {

    }

    public void sub() {

    }

    public void mul() {

    }

    public void div() {

    }
}

class Calculate {

    public static double calculation1() {
        return 1.0;
    }

    public static double calculation2() {
        return 1.0;
    }
}
