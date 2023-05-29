package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A12TheMatrix {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(scan, rows, matrix);

        String fillChar = scan.nextLine();

        int[] startingPosition = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int startRow = startingPosition[0];
        int startCol = startingPosition[1];

        String startChar = matrix[startRow][startCol];


        // where can go after start position
        //todo move - recursion?
        replaysIfCanStartCharWithFillChar(rows, cols, matrix, fillChar, startRow, startCol, startChar);


    }

    private static void replaysIfCanStartCharWithFillChar(int rows, int cols, String[][] matrix, String fillChar, int startRow, int startCol, String startChar) {

        for (int row = startRow - 1; row <= startRow + 1; row++) {

            if (row >= 0 && row < rows){

                if (matrix[row][startCol].equals(startChar)) {

                    matrix[row][startCol] = fillChar;

                }

            }

        }

        for (int col = startCol - 1; col <= startCol + 1; col++) {

            if (col >= 0 && col < cols) {

                if (matrix[startRow][col].equals(startChar)) {

                    matrix[startRow][col] = fillChar;

                }
            }
        }

    }

    private static void fillMatrix(Scanner scan, int rows, String[][] matrix) {

        for (int i = 0; i < rows; i++) {

            matrix[i] = scan.nextLine().split("\\s+");

        }
    }
}
