package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class A04SumMatrixElements2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        int sum = 0;

        for (int i = 0; i < rows; i++) {

            sum += Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).sum();

        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
