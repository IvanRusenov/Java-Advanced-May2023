package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A02KnightsOfHonor {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        Function< List<String>,  List<String>> addSir = stringList -> stringList.stream().map(e -> "Sir " + e).collect(Collectors.toList());

        Consumer <List<String>> print = stringList -> stringList.forEach(System.out::println);

        names = addSir.apply(names);
        print.accept(names);

    }
}
