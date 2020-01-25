package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        for(int i = 0; i < data.size(); i++){
            int min = Collections.min(data);
            data.remove(min);
            result.offer(min);
        }
        data.removeAll(data);
        data.addAll(result);
    }

    public static void minSort(Collection<Integer> data) {

    }

    static void collSort(Collection<Integer> data) {

    }

    public static Collection<String> compareSort() {
        Collection<String> result = null;
        return result;
    }
}
