package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[] array;
    private int lengthParent;
    private int lengthChild;
    private int currentPositionParent;
    private int currentPositionChild;

    MatrixIterator(T[] array) {
        this.array = array;
        this.currentPositionParent = 0;
        this.currentPositionChild = 0;
    }

    @Override
    public boolean hasNext() {
        return this.currentPositionParent <= this.array.length -1 ;
    }

    @Override
    public T next() {
//        T result = this.array[this.currentPosition];
//        this.currentPosition += 1;
        return null;
    }


}