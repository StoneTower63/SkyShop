package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final LinkedList<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removed = new ArrayList<>();
        if (name == null) {
            return removed;
        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (name.equals(p.getName())) {
                removed.add(p);
                iterator.remove();
            }
        }
        return removed;
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
            return;
        }
        int specialCount = 0;
        System.out.println("Содержимое корзины:");
        for (Product product : products) {
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        if (name == null) {
            return false;
        }
        for (Product product : products) {
            if (name.equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        products.clear();
    }
}
