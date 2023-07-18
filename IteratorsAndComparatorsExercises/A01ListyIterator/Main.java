package IteratorsAndComparatorsExercises.A01ListyIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ListIterator listIterator = null;

        while (!input.equals("END")) {

            if (input.startsWith("Create")) {

                if (input.length() > 7) {

                    listIterator = new ListIterator(input.substring(7).split("\\s+"));

                } else {

                    listIterator = new ListIterator();

                }


            } else if (input.startsWith("Move")) {

                System.out.println(listIterator.Move());

            } else if (input.startsWith("HasNext")) {
                System.out.println(listIterator.hasNext());
            } else if (input.startsWith("Print")) {
                try {
                    listIterator.Print();
                } catch (Exception e) {
                    System.out.println("Invalid Operation!");
                }
            }

            input = scan.nextLine();

        }


    }
}
