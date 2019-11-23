package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;
/**
 * Created by Arseniy on 22.11.2019.
 */
public class ArraySort {

    public static void main(String[] args) {

    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    int var = a[j];
                    a[j] = a[i];
                    a[i] = var;
                }
            }
        }
    }
}
