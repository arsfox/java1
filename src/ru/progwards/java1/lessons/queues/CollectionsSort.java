package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        ArrayList<Integer> arrayList = new ArrayList<>(data);

        for (int i = 0; i < arrayList.size(); i++)
        {
            for (int j = i + 1; j < arrayList.size(); j++)
            {
                if (arrayList.get(i) > arrayList.get(j))
                {
                    int var = arrayList.get(j);
                    arrayList.add(j, arrayList.get(i));
                    arrayList.add(i, var);
                }
            }
        }
        data.removeAll(data);
        data.addAll(arrayList);
    }

    public static void minSort(Collection<Integer> data) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        Iterator iterator = data.iterator();
        while (iterator.hasNext()) {
            int min = Collections.min(data);
            data.remove(min);
            result.offer(min);
        }

        data.removeAll(data);
        data.addAll(result);
    }

    static void collSort(Collection<Integer> data) {

    }

    public static Collection<String> compareSort() {
        Collection<String> result = null;
        return result;
    }
}
