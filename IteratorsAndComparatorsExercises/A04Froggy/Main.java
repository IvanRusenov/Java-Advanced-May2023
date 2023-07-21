package IteratorsAndComparatorsExercises.A04Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("END")) {

            List<Integer> lakeList = Arrays
                    .stream(input.split(",\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Lake lake = new Lake(lakeList);

            List<String> result = new ArrayList<>();

            for (Integer integer : lake) {

                result.add(integer + "");

            }

            System.out.println(String.join(", ", result));


            input = scan.nextLine();
        }

    }

}
