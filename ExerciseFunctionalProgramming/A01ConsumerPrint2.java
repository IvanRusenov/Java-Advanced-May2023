package Advanced.ExerciseFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class A01ConsumerPrint2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> input = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> consumer = System.out::println;

        input.forEach(consumer);

    }
}
