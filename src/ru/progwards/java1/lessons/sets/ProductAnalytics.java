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

    public Set<Product> notExistInShops() { // товары из products, которых нет ни в одном магазине
        List<Product> allProductsList = new ArrayList<>();
        for (Shop s : this.shops) {
            for (Product p : s.getProducts()) {
                allProductsList.add(p);
            }
        }
        Set<Product> products = new HashSet<>(allProductsList);
        Set<Product> productResult = new HashSet<>();
        for (Product p : this.products) {
            if(!products.contains(p)) {
                productResult.add(p);
            }
        }
        return productResult;
    }

    public Set<Product> existOnlyInOne() {
        List<Product> appProducts = new ArrayList<>();
        List<Product> unicornProducts = new ArrayList<>();

        for (Shop s : this.shops) {
            for (Product p : s.getProducts()) {
                appProducts.add(p);
            }
        }

        List<Product> unUnicornProducts = new ArrayList<>();

        for (int i = 0; i < appProducts.size(); i++) {
            for (int j = 0; j < appProducts.size(); j++) {
                if(i == j) continue;
                if(appProducts.get(i).equals(appProducts.get(j))) {
                    unUnicornProducts.add(appProducts.get(i));
                }
            }
        }

        for (Product p : appProducts) {
            if(!unUnicornProducts.contains(p)) {
                unicornProducts.add(p);
            }
        }

        Set<Product> productResult = new HashSet<>(unicornProducts);
        return productResult;
    }
}
