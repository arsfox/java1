package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

}
