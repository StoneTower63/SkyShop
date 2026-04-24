package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();

    public SearchEngine(int size) {
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> result = new TreeSet<>((s1, s2) -> {
            Integer res = Integer.compare(s2.getName().length(), s1.getName().length());
            if (res != 0) {
                return res;
            } else return s1.getName().compareTo(s2.getName());
        });
        for (Searchable searchable : searchables) {
            String name = searchable.getName();
            if (name.toLowerCase().contains(query.toLowerCase())) result.add(searchable);
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
