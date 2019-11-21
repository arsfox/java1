package ru.progwards.java1.lessons.bitsworld;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class CheckBit {

    public static void main(String[] args) {

    }

    public static int checkBit(byte value, int bitNumber) {
        int result = 0;
        int n = value;
        for (int i = 0; i < bitNumber; i++) {
            result = (n >> i) & 1;
        }
        return result;
    }
}
