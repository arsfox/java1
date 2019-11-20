package ru.progwards.java1.lessons.bitsworld;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class CheckBit {

    public static void main(String[] args) {
        System.out.println(checkBit((byte) 0b0010011, 3));
    }

    public static int checkBit(byte value, int bitNumber) {
        int valueInt;
        int result = 0;
        valueInt = value;
        if (bitNumber == 0) {
            return valueInt & 1;
        }

        for (int i = 0; i <= bitNumber; i++){
            value >>= 1;
            result = value;
        }
        return result;
    }
}
