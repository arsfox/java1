package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int length;
    private int currentPosition;

    ArrayIterator(T[] array) {
        this.array = array;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return this.currentPosition <= this.array.length -1;
    }

    @Override
    public T next() {
        T result = this.array[this.currentPosition];
        this.currentPosition += 1;
        return result;
    }


}
