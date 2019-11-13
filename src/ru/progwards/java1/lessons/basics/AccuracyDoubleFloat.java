package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    static final double PI = 3.14;

    static final double earthRadius = 6371.2;

    public static void main(String[] args){
        System.out.println(volumeBallDouble(earthRadius));
        System.out.println(volumeBallFloat((float) earthRadius));
        System.out.println(calculateAccuracy(earthRadius));
    }

    public static double volumeBallDouble(double r) {
        return 4 * PI * r * r * r / 3;
    }

    public static float volumeBallFloat(float r) {
        return (float) (4 *  PI * r * r * r / 3);
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallFloat((float) radius) - volumeBallDouble(radius);
    }

}
