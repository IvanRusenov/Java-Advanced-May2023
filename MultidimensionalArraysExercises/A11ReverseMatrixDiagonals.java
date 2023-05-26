package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A11ReverseMatrixDiagonals {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }


        for (int col = cols - 1; col >= 0; col--) {

            int row = rows - 1;

            printDiagonal(matrix, cols, row, col);
            System.out.println();

        }

        for (int row = rows - 2; row >= 0; row--) {

            int col = 0;

            printDiagonal(matrix, cols, row, col);
            System.out.println();

        }

    }

    private static void printDiagonal(int[][] matrix, int cols, int row, int col) {

        while (row >= 0 && col < cols) {

            System.out.printf("%d ", matrix[row][col]);
            row--;
            col++;

        }
    }
}
