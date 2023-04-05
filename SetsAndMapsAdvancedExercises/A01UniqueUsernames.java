package Advanced.SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class A01UniqueUsernames {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {

            usernames.add(scan.nextLine());

        }

        usernames.forEach(System.out::println);

    }
}
