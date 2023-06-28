package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A08CustomComparator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Integer[] intList = (Integer[]) Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> customComparator = (f, s) -> {

            if (f % 2 == 0 && s % 2 != 0) {

                return -1;

            } else if (f % 2 != 0 && s % 2 == 0) {

                return 1;

            }

            return f.compareTo(s);

        };


        Arrays.sort(intList, customComparator);

        for (Integer integer : intList) {
            System.out.print(integer + " ");
        }

    }
}
