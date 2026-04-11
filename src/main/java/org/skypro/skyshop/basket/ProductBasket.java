package org.skypro.skyshop.basket;



import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size < 5) {
            this.products[size] = product;
            size++;
        } else System.out.println("Невозможно добавить продукт");

    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {

            if (product != null) total += product.getPrice();

        }
        return total;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }

    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product != null && name.equals(product.getName())) return true;

        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < 5; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
        size = 0;

    }
}
