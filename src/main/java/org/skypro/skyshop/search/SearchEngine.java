package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();

    public SearchEngine(int size) {
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        return searchables.stream().filter(s -> s.getName().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toCollection(() -> new TreeSet<>((s1, s2) -> {

            int res = Integer.compare(s2.getName().length(), s1.getName().length());
            if (res != 0) {
                return res;
            }
            return s1.getName().compareTo(s2.getName());
        })));
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
