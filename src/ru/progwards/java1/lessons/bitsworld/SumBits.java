package ru.progwards.java1.lessons.bitsworld;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class SumBits {

    public static void main(String[] args) {

    }

    public static int sumBits(byte value) {
        int result = 0;
        int n = value;
        for (int i = 0; i < 8; i++) {
            result += (n >> i) & 1;
        }
        return result;
    }

}

