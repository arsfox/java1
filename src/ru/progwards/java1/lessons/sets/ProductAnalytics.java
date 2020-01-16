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
        List<Product> intersection = this.products;

        for (int i = 0; i <= this.shops.size(); i++) {
            for (int j = 0; j <= this.products.size(); j++) {
                if(!this.shops.get(i).getProducts().contains(this.products.get(j))){
                    intersection.remove(this.products.get(j));
                }
            }
        }
        Set<Product> productResult = new HashSet<>(intersection);
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
