package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String query) {
        super("Для запроса '" + query + "' ничего не найдено.");
    }
}
