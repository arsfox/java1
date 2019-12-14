package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    private int matrixSize, posiniton, posinitonX, posinitonY;


    MatrixIterator(T[][] array) {
        this.array = array;
        this.posiniton = 0;
        this.matrixSize = countElements(array);
        posinitonX = 0;
        posinitonY = 0;
    }

    @Override
    public boolean hasNext() {
        return this.posiniton < this.matrixSize;
    }

    @Override
    public T next() {
        T element = this.array[posinitonX][posinitonY];

        if(this.array[posinitonX].length >= 0) {
            posinitonY++;
        } else {
            posinitonY = 0;
            posinitonX++;
        }
        posiniton++;
        return element;
    }

    private int countElements(T[][] matrix) {
        int count = 0;
        for (T[] item : matrix) {
            count += item.length;
        }
        return count;
    }

}