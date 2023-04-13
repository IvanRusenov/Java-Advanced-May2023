package Advanced.SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A06FixEmails {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        Map<String, String> nameEmailMap = new LinkedHashMap<>();

        while (!name.equals("stop")) {

            String email = scan.nextLine();
            String domain = email.split("@")[1];
            String extension = domain.split("\\.")[1].toLowerCase();

            if (!(extension.equals("uk") || extension.equals("us") || extension.equals("com"))) {

                nameEmailMap.putIfAbsent(name, email);

            }

            name = scan.nextLine();

        }

        nameEmailMap.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v));

    }
}
