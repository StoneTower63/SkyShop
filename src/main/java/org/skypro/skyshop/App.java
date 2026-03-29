package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Apple", 100));
        basket.addProduct(new SimpleProduct("Banana", 50));
        System.out.println("Total: " + basket.getTotalCost());
    }
}
