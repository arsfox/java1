package ru.progwards.java1.lessons.bigints;


import java.math.BigDecimal;
import java.math.BigInteger;

public class AbsInteger {

    static public AbsInteger add(AbsInteger num1, AbsInteger num2) {
        String operandOne = "";
        String operandTwo = "";
        if(num1.getClass().equals(ByteInteger.class)) {
            operandOne = num1.;
        } else {
            operandOne = num1.toString();
            operandTwo = num2.toString();
        }

        int result = bigResult.intValue();

        if(result < 128 && result > -129) {
            return new ByteInteger((byte) result);
        } else if (result < 32768 && result > -32769) {
            return new ShortInteger((short) result);
        } else {
            return new IntInteger((short) result);
        }
    }



}
