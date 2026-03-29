package org.skypro.skyshop.product;

public class DiscountedProduct extends SimpleProduct {
    private final int discountPercent;
    public DiscountedProduct(String name, int price, int discountPercent) {
        super(name, price);
        this.discountPercent = discountPercent;
    }
    @Override
    public int getPrice() {
        int base = super.getPrice();
        return base - (base * discountPercent) / 100;
    }
}
