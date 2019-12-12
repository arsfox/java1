package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Arseniy on 12.12.2019.
 */
public class Creator {

    public static Collection<Integer> fillEven(int n) {
        Collection<Integer> collection = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            if(i % 2 == 0){
                collection.add(i);
            }
        }
        return collection;
    }

    public static Collection<Integer> fillOdd(int n) {
        Collection<Integer> collection = new ArrayList<Integer>();
        for (int i = n; i >= 1; i--) {
            if(i % 2 != 0){
                collection.add(i);
            }
        }
        return collection;
    }

    public static Collection fill3<Integer>(int n) {

    }
}
