package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Scanner;

public class A09Largest3Numbers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .forEach(e -> System.out.printf("%d ", e));

    }

}
