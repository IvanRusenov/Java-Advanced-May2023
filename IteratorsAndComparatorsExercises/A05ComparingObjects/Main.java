package IteratorsAndComparatorsExercises.A05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        List<Person> persons = new ArrayList<>();

        while (!input.equals("END")) {

            String[] personData = input.split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String town = personData[2];

            Person person = new Person(name, age, town);
            persons.add(person);

            input = scan.nextLine();

        }

        int indexOfPersonToCompare = Integer.parseInt(scan.nextLine()) - 1;

        int peopleCount = persons.size();
        int equalPeopleCount = 0;

        Person personToCompare = persons.get(indexOfPersonToCompare);

        for (Person person : persons) {

            if (person.compareTo(personToCompare) == 0) {

                equalPeopleCount++;

            }
        }

        int differentPeople = peopleCount - equalPeopleCount;

        if (equalPeopleCount == 1) {

            System.out.println("No matches");

        } else {

            System.out.printf("%d %d %d\n", equalPeopleCount, differentPeople, peopleCount);


        }


    }
}
