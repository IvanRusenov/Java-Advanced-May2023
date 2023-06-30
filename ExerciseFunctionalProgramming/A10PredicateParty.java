package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A10PredicateParty {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> people = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Party!")){

            String[] command = input.split("\\s+");

            switch (command[1]){
                case "StartsWith":

                    if (command[0].equals("Double")){
                        people.addAll(people.stream().filter(e->e.startsWith(command[2])).collect(Collectors.toList()));
                    } else if (command[0].equals("Remove")) {
                        people.removeIf(e->e.startsWith(command[2]));
                    }

                    break;
                case "EndsWith":
                    if (command[0].equals("Double")){
                        people.addAll(people.stream().filter(e->e.endsWith(command[2])).collect(Collectors.toList()));
                    } else if (command[0].equals("Remove")) {
                        people.removeIf(e->e.endsWith(command[2]));
                    }
                    break;
                case "Length":

                    if (command[0].equals("Double")){
                        people.addAll(people.stream().filter(e->e.length() == Integer.parseInt(command[2])).collect(Collectors.toList()));
                    } else if (command[0].equals("Remove")) {
                        people.removeIf(e-> e.length() == Integer.parseInt(command[2]));
                    }
                    break;
            }


            input = scan.nextLine();
        }

        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {

            System.out.printf("%s are going to the party!\n", people.stream().sorted().collect(Collectors.joining(", ")));

        }



    }
}
