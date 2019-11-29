package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {

    short shortInteger;

    public ShortInteger(short shortInteger) {
        this.shortInteger = shortInteger;
    }

    @Override
    public String toString() {
        return String.valueOf(shortInteger);
    }
}
