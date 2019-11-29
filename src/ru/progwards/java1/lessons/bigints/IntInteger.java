package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger{
    int intInteger;

    public IntInteger(int intInteger) {
        this.intInteger = intInteger;
    }

    @Override
    public String toString() {
        return String.valueOf(intInteger);
    }
}
