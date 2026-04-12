package org.skypro.skyshop.search;

import java.util.List;
import java.util.LinkedList;

public class SearchEngine {

    private final List<Searchable> searchables = new LinkedList<>();

    public SearchEngine(int size) {
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new LinkedList<>();

        for (Searchable s : searchables) {
            if (s.getSearchTerm().contains(query)) {
                result.add(s);
            }

        }
        return result;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable s : searchables) {
            int currentCount = countMatches(s.getSearchTerm(), query);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = s;
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
