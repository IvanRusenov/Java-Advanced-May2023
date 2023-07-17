package IteratorsAndComparatorsLab.A04BookComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 1920, "George Orwell");
        Book bookThree = new Book("The Documents in the Case1", 1160);
        Book bookTwo = new Book("The Documents in the Case", 3854, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new CustomBookComparator());

        for (Book book : books) {
            System.out.printf("%s %s\n",book.getTitle(),book.getYear());
        }
    }



}
