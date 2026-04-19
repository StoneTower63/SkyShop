package org.skypro.skyshop;


import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Product bread = new SimpleProduct("Хлеб", 56);
        Product milk = new SimpleProduct("Молоко", 124);
        Product meat = new SimpleProduct("Мясо", 1200);
        Product eggs = new SimpleProduct("Яйца", 104);
        Product tomatoes = new DiscountedProduct("Помидоры", 390, 20);
        Product bananas = new FixPriceProduct("Бананы");


        ProductBasket basketOne = new ProductBasket();
        basketOne.addProduct(bread);
        basketOne.addProduct(milk);
        basketOne.addProduct(meat);
        basketOne.addProduct(bananas);
        basketOne.addProduct(tomatoes);


        basketOne.printBasket();

        System.out.println(basketOne.containsProduct("Яйца"));

        System.out.println(basketOne.containsProduct("Гречка"));

        //basketOne.clear();

        basketOne.printBasket();

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
        for (Searchable s : engine.search("Хлеб").values()) {
            System.out.println(s);
        }


        System.out.println("\n Результаты поиска по слову 'Мясо' ");
        for (Searchable s : engine.search("Мясо").values()) {
            System.out.println(s);
        }

        System.out.println("\n Результаты поиска по слову 'Штора' (ничего не найдет) ");
        for (Searchable s : engine.search("Штора").values()) {
            System.out.println(s);
        }

        System.out.println("\n--- Поиск самого подходящего элемента ---");

        try {
            System.out.println("Ищем лучший результат для 'Хлеб':");
            System.out.println(engine.findBestMatch("Хлеб").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nИщем лучший результат для 'Штора':");
            System.out.println(engine.findBestMatch("Штора").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nПроверка валидации данных: ");
        try {
            new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании товара: " + e.getMessage());
        }

        //

        List<Product> removed = basketOne.removeByName("Хлеб");

        System.out.println("\nУдалено: " + removed + "\n");

        basketOne.printBasket();

        removed = basketOne.removeByName("Манго");

        if (removed.isEmpty()) System.out.println("\nСписок пуст!\n");

        basketOne.printBasket();

    }
}