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
        goods = new HashMap<>();
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
                    System.out.println(Arrays.toString(lineSeparator));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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

    public Map<String, Double> getGoods() {
        return null;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        return null;
    }
}
