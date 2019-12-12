package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Arseniy on 12.12.2019.
 */
public class Finder {

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        Collection<Integer> collection = new ArrayList<Integer>();
        return collection;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        Collection<Integer> collection = new ArrayList<Integer>();
        return collection;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        Collections.sort((ArrayList) numbers);
        int i = 1;
        for (Integer mun : numbers){
            if (mun != i){
                return false;
            }
        }
        return true;
    }
}
