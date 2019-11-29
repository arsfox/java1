package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

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
//        while (!valueInteger.equals(BigInteger.ZERO)) {
//            valueInteger = valueInteger.divide(BigInteger.TEN);
//
//            System.out.println(valueInteger.remainder(BigInteger.valueOf(10)));
//        }
        int count = 0;
        for (; !valueInteger.equals(BigInteger.ZERO); valueInteger = valueInteger.divide(BigInteger.TEN)){
            digits[count] = valueInteger.remainder(BigInteger.valueOf(10)).byteValueExact();
//            System.out.println(valueInteger.remainder(BigInteger.valueOf(10)));
            count++;
        }

        System.out.println(Arrays.toString(digits));
//        while (value.compareTo(BigDecimal.valueOf(0)) == 1) {
//            value = value.divide(BigDecimal.valueOf(10));
//            System.out.println(value);
//            System.out.println(1);
//        }
    }

    public BigDecimal toInt() {
        BigInteger result = new BigInteger("0");
        for (int count = digits.length; count > 0; count--){
            BigInteger r = new BigInteger("10").pow(count);
            BigInteger digitsIter = new BigInteger(String.valueOf(digits[count - 1]));
            BigInteger t = r.multiply(digitsIter);
            result = result.add(t);
        }
        System.out.println(result.divide(new BigInteger("10")));
        return new BigDecimal("1");
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
