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
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return (a == b || b == c || a == c);
    }
}
