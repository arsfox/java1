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

        for (int i = 0; i < this.shops.size(); i++) {
            for (int j = 0; j < this.shops.size(); j++) {
                if(i == j) continue;
                for (Product p : this.shops.get(i).getProducts()) {
                    if (this.shops.get(j).getProducts().contains(p)) {
                        intersection.add(p);
                    }
                }
            }
        }

        Set<Product> productResult = new HashSet<>(intersection);
        return productResult;
    }

    public Set<Product> existAtListInOne() { //товары из products, которые имеются хотя бы в одном магазине
        List<Product> productsList = new ArrayList<>();
        for (Shop s : this.shops) {
            for (Product p: this.products) {
                if(s.getProducts().contains(p)) {
                    productsList.add(p);
                }
            }
        }

        Set<Product> product = new HashSet<>(productsList);
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
