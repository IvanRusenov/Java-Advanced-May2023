package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A03DiagonalDifference {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];

        fillMatrix(scan, matrix);

        System.out.println(absDifferenceMatrixDiagonals(matrix));

    }

    private static void fillMatrix(Scanner scan, int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }

    private static int absDifferenceMatrixDiagonals(int[][] matrix) {

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < matrix.length; i++) {

            sum1 += matrix[i][i];
            sum2 += matrix[i][matrix.length - 1 - i];

        }

        return Math.abs(sum1 - sum2);

    }
}
