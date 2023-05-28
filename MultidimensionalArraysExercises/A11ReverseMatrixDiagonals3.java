package MultidimensionalArraysExercises;

import java.util.Scanner;

public class A11ReverseMatrixDiagonals3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, rows, cols, matrix);

        printReversedDiagonals(rows, cols, matrix);

    }

    private static void printReversedDiagonals(int rows, int cols, int[][] matrix) {

        for (int i = cols - 1; i >= 0; i--) {

            int r = rows - 1;
            int c = i;

            while (c < cols && r < rows && r >= 0 && c >= 0) {

                System.out.print(matrix[r][c] + " ");
                r--;
                c++;

            }

            System.out.println();

        }

        for (int i = rows - 2; i >= 0; i--) {

            int r = i;
            int c = 0;

            while (c < cols && r < rows && r >= 0) {

                System.out.print(matrix[r][c] + " ");
                r--;
                c++;

            }

            System.out.println();

        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = scanner.nextInt();

            }

        }

    }
}

