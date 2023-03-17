package Advanced.ExerciseFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A01ConsumerPrint {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> input = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        input.forEach(System.out::println);

    }
}
