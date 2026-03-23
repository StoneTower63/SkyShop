package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;

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

        //Полиморфизм. Интерфейсы

        SearchEngine engine = new SearchEngine(15);

        engine.add(bread);
        engine.add(milk);
        engine.add(meat);
        engine.add(eggs);
        engine.add(tomatoes);
        engine.add(bananas);

        Article breadArticle = new Article("О пользе хлеба", "Хлеб всему голова...");
        Article meatArticle = new Article("Как готовить мясо", "Мясо лучше всего жарить...");

        engine.add(breadArticle);
        engine.add(meatArticle);

        System.out.println("\n Результаты поиска по слову 'Хлеб' ");
        System.out.println(java.util.Arrays.toString(engine.search("Хлеб")));

        System.out.println("\n Результаты поиска по слову 'Мясо' ");
        System.out.println(java.util.Arrays.toString(engine.search("Мясо")));

        System.out.println("\n Результаты поиска по слову 'Штора' (ничего не найдет) ");
        System.out.println(java.util.Arrays.toString(engine.search("Штора")));

    }
}