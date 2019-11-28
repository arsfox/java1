package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

    public static void main(String[] args) {
//        System.out.println(fastPow(new BigDecimal("2"), 2));
        System.out.println(fibonacci(7));
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

    public static BigInteger fibonacci(int n) {

        BigInteger n0 = new BigInteger("1");
        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("0");

        if (n < 0){
            return new BigInteger("0");
        } else if(n == 1 || n == 2) {
            return new BigInteger("1");
        } else {
            for(int i = 3; i <= n; i++){
                n2 = n0.add(n1);
                n0 = n1;
                n1 = n2;
            }
            return n2;
        }
    }
}
