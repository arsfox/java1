package ru.progwards.java1.lessons.bigints;

import ru.progwards.java1.lessons.arrays.DIntArray;

import java.math.BigDecimal;
import java.math.BigInteger;

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
        return new BigDecimal(result.toString());
    }


    public boolean add(ArrayInteger num) {
        if (digits.length != num.digits.length){
            num.fromInt(new BigDecimal("0"));
            return false;
        }

        DIntArray dIntArray = new DIntArray();

        boolean tenths = false;
        for (int i = 0; i < digits.length; i++){
            int result = digits[i] + num.digits[i];
            if(tenths){
                result += 1;
                tenths = false;
            }
            if(result >= 10){
                result = 0;
                tenths = true;
            }
            dIntArray.add(result);
        }
       for (int i = 0; i < digits.length; i++){
           digits[i] = (byte) dIntArray.at(i);
       }
        return true;
    }


}
