package ru.progwards.java1.lessons.bitsworld;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class CheckBit {

    public static void main(String[] args) {
        System.out.println(checkBit((byte)-114, 1));
        int a = 142;
        byte b = (byte) a;
        System.out.println(b);
        System.out.println(Integer.toBinaryString(a));
    }

    public static int checkBit(byte value, int bitNumber) {
        int result = 0;
        int n = value;
        for (int i = 1; i < bitNumber; i++) {
            result = (n >> i) & 1;
        }
        return result;
    }
}
