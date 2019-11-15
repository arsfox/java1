package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {

    public static void main(String[] args){

    }

    public static int maxSide(int a, int b, int c){
        if(a >= b && a > c){
            return a;
        } else if (b > a && b >= c){
            return b;
        } else if (c >= a && c > b){
            return c;
        } else {
            return a;
        }
        //Math.max(a, Math.max(b, c));
    }

    public static int minSide(int a, int b, int c) {
        if(a <= b && a < c){
            return a;
        } else if (b < a && b <= c){
            return b;
        } else if (c <= a && c < b){
            return c;
        } else {
            return a;
        }
        //Math.min(a, Math.min(b, c));
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        return a == b && a == c;
    }
}
