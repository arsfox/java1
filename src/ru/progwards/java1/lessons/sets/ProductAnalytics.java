package ru.progwards.java1.lessons.sets;

import java.util.List;
import java.util.Set;

public class ProductAnalytics {

    class Product {

        private String code;

        public String getCode() {
            return this.code;
        }

    }

    class Shop {

        private List<Product> products;

        public Shop(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return this.products;
        }
    }

    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> product = null;
        return product;
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
