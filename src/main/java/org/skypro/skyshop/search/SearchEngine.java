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

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            int currentCount = countMatches(searchables[i].getSearchTerm(), query);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = searchables[i];
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(query);
        }

        return bestMatch;
    }

    private int countMatches(String text, String query) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(query, index)) != -1) {
            count++;
            index += query.length();
        }
        return count;
    }
}
