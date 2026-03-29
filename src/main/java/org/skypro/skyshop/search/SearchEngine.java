package org.skypro.skyshop.search;

import static java.awt.SystemColor.text;

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

    public Searchable searchBest(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxRepeats = 0;
        for (int i = 0; i < count; i++) {
            String text = searchables[i].getSearchTerm();
            int repeats = countOccurrences(text, search);
            if (repeats > maxRepeats) {
                maxRepeats = repeats;
                best = searchables[i];
            }
        }
        if (best == null) {
            throw new BestResultNotFound(search);
        } else {
            return best;
        }

    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;
        int foundIndex = text.indexOf(search, index);

        while (foundIndex != -1) {
            count++;
            index = foundIndex + search.length();
            foundIndex = text.indexOf(search, index);
        }
        return count;
    }

}
