package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    private static final double MAX_RATIO = 1.61903;
    private static final double MIN_RATIO = 1.61703;

    public static void main(String[] args){
        for (int i = 1; i < 16; i++){
            System.out.println(fiboNumber(i));
        }

        for (int i = 1; i < 101; i++){
            for (int c = 1; c < 101; c++) {
                if(isGoldenTriangle(i, i, c)) {
                    System.out.print("Triangle egde "+i);
                    System.out.println(" Triangle base "+c);
                }
            }
        }
    }

    public static boolean containsDigit(int number, int digit) {
        String numberString = String.valueOf(number);
        String digitString = String.valueOf(digit);
        return numberString.contains(digitString);
    }

    public static int fiboNumber(int n) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        if (n < 0){
            return 0;
        } else if(n == 1 || n == 2) {
            return 1;
        } else {
            for(int i = 3; i <= n; i++){
                n2=n0+n1;
                n0=n1;
                n1=n2;
            }
            return n2;
        }
    }

    public static boolean isGoldenTriangle(int a, int b, int c){
        if (TriangleInfo.isIsoscelesTriangle(a, b, c)) {
            double edge = a;
            double base = c;
            if(a == b) {
                edge = a;
                base = c;
            } else if (a == c) {
                edge = a;
                base = b;
            } else if (b == c) {
                edge = b;
                base = a;
            }

            double ratio = edge / base;
            return ratio < MAX_RATIO && ratio > MIN_RATIO;

        }
        return false;




    }
}
