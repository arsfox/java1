package ru.progwards.java1.lessons.bitsworld;

import com.sun.tools.javac.util.Assert;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class CheckBit {

    public static void main(String[] args) {

    }

    public static int checkBit(byte value, int bitNumber) {
        return (value >> bitNumber) & 0b00000001;
    }
}
