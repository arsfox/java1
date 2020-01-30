package ru.progwards.java1.lessons.queues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

public class StackCalc {

    private ArrayDeque<Double> stack = new ArrayDeque<>();

    public void push(double value) {
        stack.offerFirst(value);
    }

    public double pop() {
        return stack.pollFirst();
    }

    public void add() {
        Double x = stack.pollFirst();
        Double y = stack.pollFirst();
        stack.offerFirst(x + y);
    }

    public void sub() {
        Double x = stack.pollFirst();
        Double y = stack.pollFirst();
        stack.offerFirst(- x + y);
    }

    public void mul() {
        Double x = stack.pollFirst();
        Double y = stack.pollFirst();
        stack.offerFirst(x * y);
    }

    public void div() {
        Double x = stack.pollFirst();
        Double y = stack.pollFirst();
        stack.offerFirst(y / x);
    }

}

class Calculate {

    public static void main(String[] args) {
        System.out.println(Calculate.calculation2());
    }

    public static double calculation1() {
//        2.2*(3+12.1)
        StackCalc stack = new StackCalc();
        stack.push(2.2);
        stack.push(3);
        stack.push(12.1);
        stack.add();
        stack.mul();
        return stack.pop();
    }

    public static double calculation2() {
//        (737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2))
//        761.22 / 43.5 + 15.67 * (87 + 2 * 3.801)
//        761.22 / 43.5 + 15.67 * (87 + 2 * 3.801)
//        761.22 / 43.5 + 15.67 * (87 + 7.602)
//        761.22 / 43.5 + 15.67 * (87 + 7.602)
//        761.22 / 43.5 + 15.67 * 94.602
//        761.22 / 43.5 + 15.67 * 94.602
//        17.4993103448 + 1482.41334
//        1499.9126503448

        StackCalc stack = new StackCalc();
        stack.push(737.22);
        stack.push(24);
        stack.add();
        stack.push(55.6);
        stack.push(12.1);
        stack.sub();
        stack.div();
        stack.push(19);
        stack.push(3.33);
        stack.sub();
        stack.push(87);
        stack.push(2);
        stack.push(13.001);
        stack.push(9.2);
        stack.sub();
        stack.mul();
        stack.add();
        stack.mul();
        stack.add();
        return stack.pop();
    }
}
