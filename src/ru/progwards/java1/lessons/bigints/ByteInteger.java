package ru.progwards.java1.lessons.bigints;

/**
 * Created by Arseniy on 28.11.2019.
 */
public class ByteInteger extends AbsInteger {

    byte byteInteger;

    public ByteInteger(byte byteInteger) {
        this.byteInteger = byteInteger;
    }

    @Override
    public String toString(){
        return String.valueOf(this.byteInteger);
    }

}
