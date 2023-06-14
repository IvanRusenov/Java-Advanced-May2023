package DefiningClassesExercises.A01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> persons = new ArrayList<>();

        while (n-- >0){

            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person =  new Person(name,age);

            persons.add(person);

        }

        persons.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> {
            System.out.printf("%s - %d\n", person.getName(), person.getAge());
        });


    }
}
