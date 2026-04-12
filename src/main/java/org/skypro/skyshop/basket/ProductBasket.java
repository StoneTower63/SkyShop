package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();


    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (Product product : products) {
                System.out.println(product.toString());
                if (product.isSpecial()) specialCount++;
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }

    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (name.equals(product.getName())) return true;
        }
        return false;
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
