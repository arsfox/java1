package ru.progwards.java1.lessons.bitsworld;

/**
 * Created by Arseniy on 20.11.2019.
 */
public class Binary {

    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String result = "";
        System.out.println(num);
        for (int i = 7; i >= 0; i--) {
            int reminder = (num >> i);
            int binary = reminder & 0b00000001;
            result += binary;
        }
        return result;
    }
}
