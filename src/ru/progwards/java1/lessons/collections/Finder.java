package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Arseniy on 12.12.2019.
 */
public class Finder {

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        ArrayList<Integer> collectionArray = (ArrayList) numbers;
        Collection<Integer> collectionSumms = new ArrayList<Integer>();
        int bufferMin = Collections.max(numbers);
        int bufferPosition = 0;
        for (int i = 0; i < collectionArray.size(); i++) {
            int summ = collectionArray.get(i) + collectionArray.get(i + 1);
            if(summ < bufferMin) {
                bufferMin = summ;
                bufferPosition = i;
            }
        }
        collectionSumms.add(bufferPosition);
        collectionSumms.add(bufferPosition + 1);

        return collectionSumms;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        ArrayList<Integer> collectionArray = (ArrayList) numbers;
        Collection<Integer> collection = new ArrayList<Integer>();

        for (int i = 0; i < collectionArray.size() -1; i++) {
            if(collectionArray.get(i - 1) < collectionArray.get(i) && collectionArray.get(i) > collectionArray.get(i + 1)) {
                collection.add(i);
            }
        }
        return collection;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        Collections.sort((ArrayList) numbers);
        int i = 1;
        for (Integer mun : numbers){
            if (mun != i){
                return false;
            }
            i++;
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        return "";
    }

}
