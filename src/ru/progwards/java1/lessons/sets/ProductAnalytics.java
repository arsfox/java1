package ru.progwards.java1.lessons.sets;

import java.util.List;
import java.util.Set;

public class ProductAnalytics {

    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> productResult = null;
        Set<Product> allProduct;

        for (int i = 0; i < this.shops.size(); i++) {
            for (int j = 0; j < products.size(); j++) {
                if(shops.get(i).getProducts().contains(products.get(j))) {

                }
            }
        }

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
