package Advanced.SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class A02SetsOfElements {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int n = Integer.parseInt(input.split("\\s+")[0]);
        int m = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {

            firstSet.add(Integer.parseInt(scan.nextLine()));

        }

        for (int i = 0; i < m; i++) {

            secondSet.add(Integer.parseInt(scan.nextLine()));
        }

        for (int num : firstSet) {
            if (secondSet.contains(num)) {
                System.out.printf("%d ", num);
            }
        }

    }
}