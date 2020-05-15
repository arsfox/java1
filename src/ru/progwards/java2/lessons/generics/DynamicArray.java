package ru.progwards.java2.lessons.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray<T>  {

    private T[] array;
    private int size;
    private int offset;
    private int length;

    DynamicArray(int size){
        this.size = size;
        array = (T[]) new Object[size];
    }

    public void add(T item) {
        updateArray();
        array[offset++] = item;
        length++;
    }

    public void insert(int pos, T item ){
        updateArray();
        if(pos > size){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            array[pos] = item;
            length++;
        }
    }

    public void remove(int pos) {
        if(pos > size){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            array[pos] = null;
            length--;
        }
    }

    public T get(int pos) {
        return array[pos];
    }

    public int size() {
        return this.size;
    }

    private void updateArray() {
        if(length==size){
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

}
