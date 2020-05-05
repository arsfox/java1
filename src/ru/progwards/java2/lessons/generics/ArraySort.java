package ru.progwards.java2.lessons.generics;


public class ArraySort {

    public static <T extends Comparable> void sort(T... list) {

        for (int i = 0; i < list.length; i++)
        {
            for (int j = i + 1; j < list.length; j++)
            {
                if (list[i].compareTo(list[j]) > 0)
                {
                    T var = list[j];
                    list[j] = list[i];
                    list[i] = var;
                }
            }
        }


    }

}
