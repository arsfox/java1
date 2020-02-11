package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Arseniy on 05.02.2020.
 */
public class SalesInfo {

    Map<String, Double> goods;
    Map<String, AbstractMap.SimpleEntry<Double, Integer>> customers;

    public SalesInfo() {
        goods = new TreeMap<>();
        customers = new HashMap<>();
    }

    public int loadOrders(String fileName) {
        int successLoadingLine = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String lineText = scanner.nextLine();
                String[] lineSeparator = lineText.split(", ", 4);
                if(lineSeparator.length == 4) {
                    int countGood = getInt(lineSeparator[2]);
                    Double priceGood = getDouble(lineSeparator[3]);
                    if(countGood != -1 && priceGood != -1d){
                        this.addGood(lineSeparator[1], countGood, priceGood);
                        successLoadingLine++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return successLoadingLine;
    }

    private int getInt(String string) {
            try {
                int num = Integer.parseInt(string);
                return num;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return -1;
    }

    private Double getDouble(String string) {
        try {
            Double num = Double.valueOf(string);
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1d;
    }

    private void addGood(String name, int count, double price) {
        if(goods.containsKey(name)){
            Double summ = goods.get(name);
            summ += price * count;
            goods.put(name, summ);
        } else {
            Double summ = price * count;
            goods.put(name, summ);
        }
    }

    public Map<String, Double> getGoods() {
        return this.goods;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        return null;
    }
}
