package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {

    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() { // товары из products, которые имеются во всех магазинах
        List<Product> intersection = new ArrayList<>();
//      Set<Product> tmp = new HashSet<>();
        List<Product> tmp = new ArrayList<>();

        for (int i = 0; i < this.shops.size(); i++) {
            for (int j = 0; j < this.shops.size(); j++) {
                for (Product productOne : this.shops.get(i).getProducts()) {
                    for (Product productTwo : this.shops.get(j).getProducts()) {
                        if(productOne.equals(productTwo)) {
                            tmp.add(productOne);
                        }
                    }
                }
            }
        }

        Set<Product> productResult = new HashSet<>(tmp);
        return productResult;
    }

    public Set<Product> existAtListInOne() {
        Set<Product> product = null;
        return product;
    }

    public Set<Product> notExistInShops() {
        Set<Product> product = null;
        return product;
    }

    public Set<Product> existOnlyInOne() {
        Set<Product> product = null;
        return product;
    }
}
