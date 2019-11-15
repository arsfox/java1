package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    static final float MAX_RATIO = 1.61903f;
    static final float MIN_RATIO = 1.61703f;

    public static void main(String[] args){
        for (int i = 1; i < 16; i++){
//            System.out.println(fiboNumber(i));
        }

        for (int i = 1; i < 101; i++){
            for (int c = 1; c < 101; c++) {
                System.out.println(isGoldenTriangle(i, i, c));
            }
        }
    }

    public static boolean containsDigit(int number, int digit) {
        String numberString = String.valueOf(number);
        String digitString = String.valueOf(digit);
        if (numberString.contains(digitString)) {
            return true;
        }
        return false;
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
        if(TriangleInfo.isIsoscelesTriangle(a, b, c)) return false;
        float edge = Math.min(a, Math.min(b, c));
        float base = Math.max(a, Math.max(b, c));

        float ratio = base / edge;

        System.out.println(MIN_RATIO+" "+ratio+" "+MAX_RATIO);

        if(ratio < MAX_RATIO && ratio > MIN_RATIO) {
            return true;
        }
        return false;
    }
}
