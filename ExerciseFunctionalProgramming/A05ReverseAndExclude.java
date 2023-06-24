package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class A05ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> intList  = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());

        Consumer<List<Integer>> reverse = Collections::reverse;
        Consumer<List<Integer>> removeN = integerList -> integerList.removeIf(e-> e % n == 0);
        Consumer<List<Integer>> print = integerList -> System.out.printf("%s\n", integerList.stream().map(e -> e + "").collect(Collectors.joining(" ")));

        reverse.accept(intList);
        removeN.accept(intList);
        print.accept(intList);

    }


}
