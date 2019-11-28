package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;

public class BigAlgebra {

    public static void main(String[] args) {
        System.out.println(fastPow(new BigDecimal("2"), 2));
    }

    public static BigDecimal fastPow(BigDecimal num, int pow){
        if (pow == 0){
            return new BigDecimal("1");
        }

        BigDecimal result = new BigDecimal("1");

        while (pow > 0) {
            if (pow % 2 == 1) {
                pow = pow - 1;
                result = result.multiply(num);
            } else {
                pow /= 2;
                num = num.multiply(num);
            }
        }
        return result;
    }
}
