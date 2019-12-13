package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Arseniy on 12.12.2019.
 */
public class Creator {

    public static Collection<Integer> fillEven(int n) {
        Collection<Integer> collection = new ArrayList<Integer>(n);
        for (int i = 0; collection.size() < n; i++) {
            if(i % 2 == 0){
                collection.add(i);
            }
        }
        return collection;
    }

    public static Collection<Integer> fillOdd(int n) {
        Collection<Integer> collection = new ArrayList<Integer>();
        for (int i = n; i >= 1;) {
            if(i % 2 != 0){
                collection.add(i);
                i--;
            }
        }
        return collection;
    }

    public static Collection<Integer> fill3(int n) {
        Collection<Integer> collection = new ArrayList<Integer>();
        for (int i = 0; collection.size() < n; i+=3) {
            collection.add(i);
            collection.add(i*i);
            collection.add(i*i*i);
        }
        return collection;
    }
}
