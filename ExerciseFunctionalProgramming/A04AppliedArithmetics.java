package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A04AppliedArithmetics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = integerList -> integerList.stream().map(e-> e + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = integerList -> integerList.stream().map(e-> e * 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = integerList -> integerList.stream().map(e-> e - 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = integerList -> System.out.printf("%s\n", integerList.stream().map(e -> e + "").collect(Collectors.joining(" ")));

        String command = scan.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    intList = add.apply(intList);
                    break;
                case "multiply":
                    intList = multiply.apply(intList);
                    break;
                case "subtract":
                    intList = subtract.apply(intList);
                    break;
                case "print":
                    print.accept(intList);
                    break;

            }

            command = scan.nextLine();
        }
    }
}
