package ru.progwards.java1.lessons.bigints;


import java.math.BigDecimal;

public class AbsInteger {

    public AbsInteger add(AbsInteger num1, AbsInteger num2) {
        BigDecimal bigNum1 = new BigDecimal(num1.toString());
        BigDecimal bigNum2 = new BigDecimal(num2.toString());

        BigDecimal bigResult = bigNum1.add(bigNum2);

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
