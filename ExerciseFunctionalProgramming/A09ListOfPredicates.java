package FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A09ListOfPredicates {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Integer> intList = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> newList = new ArrayList<>();


        Predicate<Integer> isDivisible = integer -> {
            for (Integer integer1 : intList) {
                if (integer % integer1 != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {

            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }

        }
    }
}
