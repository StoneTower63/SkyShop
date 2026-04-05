package main.main.java.org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
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
