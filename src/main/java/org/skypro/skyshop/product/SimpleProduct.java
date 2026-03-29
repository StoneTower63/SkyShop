package org.skypro.skyshop.product;

public class SimpleProduct implements Product {
    private final String name;
    private final int price;

    public SimpleProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getPrice() { return price; }
}
