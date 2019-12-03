package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class AbsInteger {

    static public AbsInteger add(AbsInteger num1, AbsInteger num2) {
        String operandOne = "";
        String operandTwo = "";

        if(num1.getClass().equals(ByteInteger.class) && num2.getClass().equals(ByteInteger.class)) {
            operandOne = String.valueOf(new ByteInteger((byte) num1.getInt()));
            operandTwo = String.valueOf(new ByteInteger((byte) num2.getInt()));
        } else if (num1.getClass().equals(ByteInteger.class)) {
            operandOne = String.valueOf(new ByteInteger((byte) num1.getInt()));
            operandTwo = num2.toString();
        } else if (num2.getClass().equals(ByteInteger.class)) {
            operandTwo = String.valueOf(new ByteInteger((byte) num2.getInt()));
            operandOne = num1.toString();
        } else {
            operandOne = num1.toString();
            operandTwo = num2.toString();
        }

        BigInteger bigNum1 = new BigInteger(operandOne);
        BigInteger bigNum2 = new BigInteger(operandTwo);

        BigInteger bigResult = bigNum1.add(bigNum2);

        int result = bigResult.intValue();

        if(result < 128 && result > -129) {
            return new ByteInteger((byte) result);
        } else if (result < 32768 && result > -32769) {
            return new ShortInteger((short) result);
        } else {
            System.out.println("IntInteger");
            return new IntInteger(result);
        }
    }

    public int getInt() {
        return 0;
    }


}
