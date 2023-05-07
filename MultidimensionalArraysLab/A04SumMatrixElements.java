package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class A04SumMatrixElements {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];
        int sum = 0;

        for (int i = 0; i < rows; i++) {

            int[] in = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = in[j];
                sum+=matrix[i][j];

            }

        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
