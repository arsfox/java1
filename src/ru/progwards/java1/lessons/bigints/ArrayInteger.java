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
        System.out.print("fromInt: ");
        System.out.println(Arrays.toString(digits));
    }

    public BigDecimal toInt() {
        BigInteger result = new BigInteger("0");
        for (int count = digits.length; count > 0; count--){
            BigInteger r = new BigInteger("10").pow(count);
            BigInteger digitsIter = new BigInteger(String.valueOf(digits[count - 1]));
            BigInteger t = r.multiply(digitsIter);
            result = result.add(t);
        }
        return new BigDecimal(result.divide(new BigInteger("10")));
    }


    public boolean add(ArrayInteger num) {
        if (digits.length < num.digits.length){
            num.fromInt(new BigDecimal("0"));
            return false;
        }

        DIntArray dIntArray = new DIntArray();

        byte[] memArray = new byte[digits.length];
        Arrays.fill(memArray, (byte) 0);



        for (int c = 0; c < memArray.length; c ++){
            if(c < num.digits.length) {
                memArray[c] = num.digits[c];
            }
        }
        int dNum = 0;
        int result = 0;

        boolean tenths = false;
        for (int i = 0; i < digits.length; i++){
             result = digits[i] + memArray[i] + dNum;
             dNum = result / 10;
             if (result > 9) {
                 result = result % 10;
             }

            dIntArray.add(result);
       }
       for (int i = 0; i < digits.length; i++){
           digits[i] = (byte) dIntArray.at(i);
       }

       return true;
    }


}
