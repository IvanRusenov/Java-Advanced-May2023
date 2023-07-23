package IteratorsAndComparatorsExercises.A06StrategyPattern;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scan.nextLine());
        Set<Person> personsSortByNameLength = new TreeSet<>(new CompareByName());
        Set<Person> personsSortByAge = new TreeSet<>(new CompareByAge());

        while (peopleCount-- > 0) {

            String[] input = scan.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            personsSortByNameLength.add(person);
            personsSortByAge.add(person);

        }

        for (Person person : personsSortByNameLength) {
            System.out.printf("%s %d\n", person.getName(), person.getAge());
        }

        for (Person person : personsSortByAge) {
            System.out.printf("%s %d\n", person.getName(), person.getAge());
        }

    }
}
