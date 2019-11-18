package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {

    public static void main(String[] args){
        System.out.println(isRightTriangle(12, 12, 16));
    }

    public static boolean isTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        if (((a + b) > c)&&((a + c) > b)&&((c + b) > a)) {
            return true;
        }
        return false;
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        if (!isTriangle(a, b, c)) return false;
        int cathetOne;
        int cathetTwo;
        int hypotenuse;

        if(a > c && a > b) {
            cathetOne = c;
            cathetTwo = b;
            hypotenuse = a;
        } else if (b > c && b > a) {
            cathetOne = a;
            cathetTwo = c;
            hypotenuse = b;
        } else if (c > b && c > a) {
            cathetOne = a;
            cathetTwo = b;
            hypotenuse = c;
        } else {
            return false;
        }

        return cathetOne * cathetOne + cathetTwo * cathetTwo == hypotenuse * hypotenuse;
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        if (!isTriangle(a, b, c)) return false;
        return (a == b || b == c || a == c);
    }
}
