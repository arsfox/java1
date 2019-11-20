package ru.progwards.java1.lessons.bitsworld;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class SumBits {

    public static void main(String[] args) {

    }

    public static int sumBits(byte value) {
        int valueInt;
        int result = 0;
        valueInt = value;
        result += valueInt & 1;

        for (int i = 0; i < 8; i++){
            value >>= 1;
            valueInt = value;
            result += valueInt & 1;
        }
        return result;
    }
}
