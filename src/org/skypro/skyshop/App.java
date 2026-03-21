package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Product bread = new Product("Хлеб", 56);
        Product milk = new Product("Молоко", 124);
        Product meat = new Product("Мясо", 1200);
        Product eggs = new Product("Яйца", 104);
        Product cheese = new Product("Сыр", 207);
        Product oil = new Product("Масло", 189);

        System.out.println("Задание 1");
        ProductBasket basketOne = new ProductBasket();
        basketOne.addProduct(bread);
        basketOne.addProduct(milk);
        basketOne.addProduct(meat);
        basketOne.addProduct(eggs);
        basketOne.addProduct(cheese);

        System.out.println("Задание 2");
        basketOne.addProduct(oil);

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
