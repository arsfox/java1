package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        ArrayDeque<Integer> list = new ArrayDeque<>(data);

        for(int i = 0; i < data.size(); i++){
            int min = Collections.min(list);
            list.remove(min);
            list.offer(min);
        }
        data.removeAll(data);
        data.addAll(list);
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
