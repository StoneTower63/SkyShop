package org.skypro.skyshop.basket;



import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                    System.out.println(product.toString());
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean containsProduct(String name) {
        return products.containsKey(name);
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removeProduct = products.remove(name);
        if (removeProduct != null) {
            return removeProduct;
        } else {
            System.out.println("Такого наименования нет в корзине!");
            return new LinkedList<>();
        }
    }
}

