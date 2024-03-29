package IteratorsAndComparatorsLab.A04BookComparator;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {

        if (authors.length > 0) {
            this.authors = Arrays.asList(authors);
        }
    }

    @Override
    public int compareTo(Book o) {

        int result =  this.title.compareTo(o.title);
        if (result == 0) {
            result = Integer.compare(this.year,o.year);
        }
        return result;
    }
}
