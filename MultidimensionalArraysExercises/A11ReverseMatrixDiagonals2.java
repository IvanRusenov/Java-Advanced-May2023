package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A11ReverseMatrixDiagonals2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, rows, matrix);

        printMatrixDiagonalsInReverseOrder(matrix, rows, cols);

    }

    private static void fillMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {

            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
    }

    private static void printMatrixDiagonalsInReverseOrder(int[][] matrix, int rows, int cols) {

        for (int col = cols - 1; col >= 0; col--) {
            int row = rows - 1;
            printDiagonal(matrix, row, col);
            System.out.println();
        }

        for (int row = rows - 2; row >= 0; row--) {
            int col = 0;
            printDiagonal(matrix, row, col);
            System.out.println();
        }

    }

    private static void printDiagonal(int[][] matrix, int row, int col) {

        while (row >= 0 && col < matrix[0].length) {
            System.out.printf("%d ", matrix[row][col]);
            row--;
            col++;
        }
    }
}
