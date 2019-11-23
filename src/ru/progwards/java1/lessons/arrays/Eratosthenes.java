package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;
//Последовательность составных чисел начинается так: false
//4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26,
//
//Последовательность простых чисел начинается так: true
//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,

public class Eratosthenes {

    private boolean[] sieve;
    private int N;

    public Eratosthenes(int N) {
        this.N = N;
        sieve = new boolean[N + 1];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i < sieve.length; ++i){
            if (sieve[i]) {
                for (int j = 2; i * j < sieve.length; ++j) {
                    sieve[i * j] = false;
                }
            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
    }
}
