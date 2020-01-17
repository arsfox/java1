package ru.progwards.java1.lessons.sets;

import java.util.Objects;

class Product {

    private String code;

    public Product(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return this.code.equals(product.getCode());
    }

    @Override
    public int compareTo(Product animal) {
        if (getWeight() < animal.getWeight()) {
            return -1;
        }
        else if (getWeight() > animal.getWeight()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
