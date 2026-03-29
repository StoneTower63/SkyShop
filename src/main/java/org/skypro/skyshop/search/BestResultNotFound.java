package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {

    public BestResultNotFound(String search) {
        super("По запросу '" + search + "' лучший результат не найден");
    }

}
