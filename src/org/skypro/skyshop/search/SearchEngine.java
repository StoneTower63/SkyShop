package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int countMatches = 0;

        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(query)) {
                result[countMatches] = searchables[i];
                countMatches++;

                if (countMatches == 5) {
                    break;
                }
            }
        }
        return result;
    }
}
