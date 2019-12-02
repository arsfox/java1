package ru.progwards.java1.lessons.bigints;

/**
 * Created by Arseniy on 22.11.2019.
 */
public class DIntArray {

    private int[] intArray;

    public DIntArray() {
        intArray = new int[0];
    }

    public void add(int num) {
        int[] intArrayCopy = new int[intArray.length + 1];
        System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
        intArrayCopy[intArrayCopy.length - 1] = num;
        intArray = intArrayCopy;
    }

    public void atInsert(int pos, int num) {
        int[] intArrayCopy = new int[intArray.length + 1];

        for (int i = 0; i < intArrayCopy.length; i++){
            if(i < pos){
                intArrayCopy[i] = intArray[i];
            } else if (i == pos) {
                intArrayCopy[i] = num;
            } else {
                intArrayCopy[i] = intArray[i-1];
            }
        }
        intArray = intArrayCopy;
    }

    public void atDelete(int pos) {
        int[] intArrayCopy = new int[intArray.length - 1];
        for (int i = 0; i < intArray.length; i++) {
            if(i < pos){
                intArrayCopy[i] = intArray[i];
            } else if (i > pos) {
                intArrayCopy[i-1] = intArray[i];
            }
        }
        intArray = intArrayCopy;
    }

    public int at(int pos) {
        return intArray[pos];
    }

    public int[] get(){
        return intArray;
    }

}
