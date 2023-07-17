package IteratorsAndComparatorsLab.A04BookComparator;

import java.util.Comparator;

public class CustomBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book f, Book s) {

      return Integer.compare(f.getYear(),s.getYear());


    }
}
