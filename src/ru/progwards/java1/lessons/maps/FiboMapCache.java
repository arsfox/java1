package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Arseniy on 05.02.2020.
 */
public class FiboMapCache {

    private Map<Integer, BigDecimal> fiboCache;
    private boolean cacheOn;

    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
        fiboCache = new HashMap<>();
    }

    public BigDecimal fiboNumber(int n) {
        if(cacheOn) {
            if(fiboCache.containsKey(n)){
                return fiboCache.get(n);
            } else {
                BigDecimal dm = fibonacci(n);
                fiboCache.put(n, dm);
                return dm;
            }
        } else {
            return fibonacci(n);
        }
    }

    public void clearCahe() {
        fiboCache.clear();
    }

    private static BigDecimal fibonacci(int n) {

        BigInteger n0 = new BigInteger("1");
        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("0");

        if (n < 0){
            return new BigDecimal("0");
        } else if(n == 1 || n == 2) {
            return new BigDecimal("1");
        } else {
            for(int i = 3; i <= n; i++){
                n2 = n0.add(n1);
                n0 = n1;
                n1 = n2;
            }
            return new BigDecimal(n2);
        }
    }

    public static void test() {

    }
}
