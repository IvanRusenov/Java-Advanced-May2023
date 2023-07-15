package IteratorsAndComparatorsLab.A02Library2;

import java.util.Arrays;
import java.util.Iterator;

public class Library <Book>implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        setBooks(books);
    }

    public void setBooks(Book... books) {
        if (books != null) {
            this.books = books;
        }
    }

    @Override
    public Iterator<Book> iterator() {

        return Arrays.stream(books).iterator();

//        return new Iterator<Book>() {
//            private int i = 0;
//
//            @Override
//            public boolean hasNext() {
//                return i < books.length;
//            }
//
//            @Override
//            public Book next() {
//                return books[i++];
//            }
//        };
    }
}
