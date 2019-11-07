package ru.progwards.java1.lessons.helloworld;

public class Task2 {

    public static void main(String[] args) {
        subtraction(89, 55);
    }

    public static void subtraction(int x, int y) {
        int z;
        z = x - y;

        System.out.print("Вызвана функция subtraction() с параметрами x = ");
        System.out.print(x);
        System.out.print(", y = ");
        System.out.println(y);
        System.out.print("Результат z = ");
        System.out.println(z);
    }
}
