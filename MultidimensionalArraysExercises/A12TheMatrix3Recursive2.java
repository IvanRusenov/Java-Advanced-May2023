package MultidimensionalArraysExercises;

import java.util.Scanner;

public class A12TheMatrix3Recursive2 {
    private static char[][] matrix;
    private static int numRows, numCols;
    private static char fillChar, startChar;
    private static int startRow, startCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numRows = scanner.nextInt();
        numCols = scanner.nextInt();
        matrix = new char[numRows][numCols];

        // Read the matrix from input
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = scanner.next().charAt(0);
            }
        }

        fillChar = scanner.next().charAt(0);
        startRow = scanner.nextInt();
        startCol = scanner.nextInt();
        startChar = matrix[startRow][startCol];

        fill(startRow, startCol);

        // Print the matrix after the fill operation
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fill(int row, int col) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || matrix[row][col] != startChar) {
            // Stop recursion if we're out of bounds or if we've reached a different character
            return;
        }

        // Change the current character to the fill character
        matrix[row][col] = fillChar;

        // Recursively call fill() for each adjacent cell
        fill(row - 1, col);
        fill(row + 1, col);
        fill(row, col - 1);
        fill(row, col + 1);
    }
}


