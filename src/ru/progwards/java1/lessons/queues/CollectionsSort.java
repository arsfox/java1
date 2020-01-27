package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        ArrayList<Integer> arrayList = new ArrayList<>(data);

        for (int i = arrayList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    Collections.swap(arrayList, j, j + 1);
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

        class SortMethod implements Comparable<SortMethod> {
            String name;
            Long time;
            SortMethod(String name, Long time){
                this.name = name;
                this.time = time;
            }

            @Override
            public int compareTo(SortMethod sortMethod) {
                if (this.time < sortMethod.time) {
                    return -1;
                }
                else if (this.time > sortMethod.time){
                    return 1;
                }
                else {
                    return 0;
                }
            }

            @Override
            public String toString() {
                return this.name+" "+this.time;
            }
        }

        ArrayList<SortMethod> sortMethod = new ArrayList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            arrayList.add(new Random().nextInt(10000));
        }

        long start1 = System.currentTimeMillis();
        ArrayList<Integer> arrayList1 = arrayList;
        mySort(arrayList1);
        sortMethod.add(new SortMethod("mySort", System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        ArrayList<Integer> arrayList2 = arrayList;
        minSort(arrayList2);
        sortMethod.add(new SortMethod("minSort", System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        ArrayList<Integer> arrayList3 = arrayList;
        minSort(arrayList3);
        sortMethod.add(new SortMethod("collSort", System.currentTimeMillis() - start3));

        Collections.sort(sortMethod);

        Collection<String> result = new ArrayList<>();

        for (int i = 0; i < sortMethod.size(); i++) {
            result.add(sortMethod.get(i).name);
        }
        return result;
    }
}
