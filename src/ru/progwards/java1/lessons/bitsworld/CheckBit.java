package ru.progwards.java1.lessons.bitsworld;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class CheckBit {

    public static void main(String[] args) {
        System.out.println(checkBit((byte) 0b00100111, 4));
    }

    public static int checkBit(byte value, int bitNumber) {
        int valueInt;
        int result = 0;

        int i = 0;
        do {
            valueInt = value;
            result = valueInt & 1;
            value >>= 1;
            i++;
        } while (bitNumber > i);

        return result;
    }
}
