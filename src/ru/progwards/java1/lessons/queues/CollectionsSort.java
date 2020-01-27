package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {
//[4, 14, 41, 1, 6, 49, 39, 35, 42, 28, 13, 5, 0, 39, 20, 40, 16, 17, 9, 13, 37, 44, 38, 18, 40]
    public static void mySort(Collection<Integer> data) {
        ArrayList<Integer> arrayList = new ArrayList<>(data);

        for (int i = arrayList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    Collections.swap((List<Integer>) arrayList, j, j + 1);
                }
            }
        }

        data.removeAll(arrayList);
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
        Collections.sort((List<Integer>) data);
    }

    public static Collection<String> compareSort() {
        Collection<String> result = null;
        return result;
    }
}
