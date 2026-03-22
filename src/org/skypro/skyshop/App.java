package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        Product bread = new SimpleProduct("Хлеб", 56);
        Product milk = new SimpleProduct("Молоко", 124);
        Product meat = new SimpleProduct("Мясо", 1200);
        Product eggs = new SimpleProduct("Яйца", 104);
        Product tomatoes = new DiscountedProduct("Помидоры", 390, 20);
        Product bananas = new FixPriceProduct("Бананы");

        System.out.println("Задание 1");
        ProductBasket basketOne = new ProductBasket();
        basketOne.addProduct(bread);
        basketOne.addProduct(milk);
        basketOne.addProduct(meat);
        basketOne.addProduct(bananas);
        basketOne.addProduct(tomatoes);

        System.out.println("Задание 2");
        basketOne.addProduct(bananas);

        System.out.println("Задание 3 и 4");
        basketOne.printBasket();

        System.out.println("Задание 5");
        System.out.println(basketOne.containsProduct("Яйца"));

        System.out.println("Задание 6");
        System.out.println(basketOne.containsProduct("Гречка"));

        System.out.println("Задание 7");
        basketOne.clear();

        System.out.println("Задание 8 и 9");
        basketOne.printBasket();

        System.out.println("Задание 10");
        System.out.println(basketOne.containsProduct("Мясо"));

    }
}
