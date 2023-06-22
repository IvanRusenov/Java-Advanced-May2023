package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A03CustomMinFunction {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> intList  = Arrays.stream(scan.nextLine()
                                .split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        Function< List<Integer>, Integer> minElement = integerList -> integerList.stream().min(Comparator.naturalOrder()).get();
        System.out.println(minElement.apply(intList));
    }
}
