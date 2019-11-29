package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ArrayInteger {

    private int n;
    byte[] digits;

    public ArrayInteger(int n){
        this.n = n;
        digits = new byte[n];

//        while (n != 0) {
//            n /= 10;
//            System.out.println(n);
//        }
    }

    public void fromInt(BigDecimal value) {
        BigInteger valueInteger = value.toBigInteger();
        BigInteger valueIntegerS = value.toBigInteger();
        while (!valueInteger.equals(BigInteger.ZERO)) {
            valueInteger = valueInteger.divide(BigInteger.TEN);

            System.out.println(valueInteger.remainder(BigInteger.valueOf(10)));
        }


//        while (value.compareTo(BigDecimal.valueOf(0)) == 1) {
//            value = value.divide(BigDecimal.valueOf(10));
//            System.out.println(value);
//            System.out.println(1);
//        }
    }

//    private int getCountsOfDigits(long number) {
//        int count = (number == 0) ? 1 : 0;
//        while (number != 0) {
//            count++;
//            number /= 10;
//        }
//        return count;
//    }

}
