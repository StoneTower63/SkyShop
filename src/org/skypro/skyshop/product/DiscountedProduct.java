package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");
        }
        this.basePrice = basePrice;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка не может быть отрицательной либо более 100 процентов");
        }
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + getPrice() + " (" + getDiscount() + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
