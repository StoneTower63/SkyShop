package org.skypro.skyshop.article;


import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }


    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else return this.name.equals(((Article) o).name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
