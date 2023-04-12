package Advanced.SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A05Phonebook {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, String> nameNumberMap = new HashMap<>();

        while (!input.equals("search")) {

            String name = input.split("-")[0];
            String number = input.split("-")[1];

            nameNumberMap.put(name, number);

            input = scan.nextLine();
        }

        String name = scan.nextLine();

        while (!name.equals("stop")) {

            if (nameNumberMap.containsKey(name)) {

                System.out.printf("%s -> %s\n", name, nameNumberMap.get(name));

            } else {

                System.out.printf("Contact %s does not exist.\n", name);

            }

            name = scan.nextLine();
        }
    }
}
