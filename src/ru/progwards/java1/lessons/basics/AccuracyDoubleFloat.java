package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    static final double PI = 3.14;

    static final double earthRadius = 6371.2;

    public static void main(String[] args){
        System.out.println(volumeBallDouble(earthRadius));
        System.out.println(volumeBallFloat((float) earthRadius));
        System.out.println(calculateAccuracy(earthRadius));
    }

    public static double volumeBallDouble(double radius) {
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }

    public static float volumeBallFloat(float radius) {
        return (float) (4 * Math.PI * Math.pow(radius, 3) / 3);
    }

    public static double calculateAccuracy(double radius) {
        double a = volumeBallDouble(radius);
        double b = volumeBallFloat((float) radius);
        return volumeBallDouble(radius) - volumeBallFloat((float) radius);
    }

}
