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
    }

    public void fromInt(BigDecimal value) {
        BigInteger valueInteger = value.toBigInteger();
        int count = 0;
        for (; !valueInteger.equals(BigInteger.ZERO); valueInteger = valueInteger.divide(BigInteger.TEN)){
            digits[count] = valueInteger.remainder(BigInteger.valueOf(10)).byteValueExact();
            count++;
        }
//        System.out.println(Arrays.toString(digits));
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

//    TODO It's not ready yet
    public boolean add(ArrayInteger num) {
        int count = Math.max(this.digits.length, num.digits.length);


        System.out.println(count);
        return true;
    }


}
