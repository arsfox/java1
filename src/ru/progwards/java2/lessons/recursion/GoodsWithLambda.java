package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsWithLambda {

    private static List<Goods> goods = new ArrayList<>();

    public static void main(String[] args) {
        GoodsWithLambda gwl = new GoodsWithLambda();

        gwl.setGoods(new ArrayList<>(List.of(
            new Goods("Btest", "1234", 0, 1.1, Instant.now()),
            new Goods("Ctest", "3234", 0, 1.1, Instant.now()),
            new Goods("Atest", "2234", 1, 2.1, Instant.now())
        )));

        System.out.println(gwl.sortByNumber());

    }

    void setGoods(List<Goods> list) {
        goods.addAll(list);
    }

    List<Goods> sortByName(){  //- вернуть список, отсортированный по наименованию
        goods.sort(Comparator.comparing(a -> a.name));
        return goods;
    }

    List<Goods> sortByNumber() { // вернуть список, отсортированный по артикулу, без учета регистра
        goods.sort(Comparator.comparing(a -> a.number));
        return goods;
    }

    List<Goods> sortByPartNumber() { // - вернуть список, отсортированный по первым 3-м символам артикула, без учета регистра
        goods.sort(Comparator.comparing(a -> a.number.substring(0, 3)));
        return goods;
    }

    List<Goods> sortByAvailabilityAndNumber() { //  - вернуть список, отсортированный по количеству, а для одинакового количества, по артикулу, без учета регистра
        goods.stream().sorted(Comparator.comparingInt(a -> a.available)).sorted(Comparator.comparing(a -> a.number)).collect(Collectors.toList());
        return goods;
    }

    List<Goods> сountLess(int count) { //  - вернуть список, с товаром, количество на складе которого меньше указанного
        goods.stream().sorted().takeWhile(e -> e.available < count).collect(Collectors.toList());
        return goods;
    }

    List<Goods> сountBetween(int count1, int count2) { // - вернуть список, с товаром, количество на складе которого больше count1 и меньше count2
        goods.stream().sorted().takeWhile(e -> e.available < count2).dropWhile(e -> e.available < count1).collect(Collectors.toList());
        return goods;
    }
}

class Goods {
    String name; // - наименование
    String number; // - артикул
    int available; // - количество на складе
    double price; // - цена
    Instant expired; // - срок годности

    public Goods(String name, String number, int available, double price, Instant expired) {
        this.name = name;
        this.number = number;
        this.available = available;
        this.price = price;
        this.expired = expired;
    }

    @Override
    public String toString() {
        return name+" "+number+" "+available+" "+price+" "+expired;
    }
}
