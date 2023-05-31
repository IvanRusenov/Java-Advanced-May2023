package MultidimensionalArraysExercises;

import java.util.Scanner;

public class A12TheMatrix3Recursive {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        char[][] matrix = new char[numRows][numCols];

        readMatrix(scanner, numRows, numCols, matrix);

        char fillChar = scanner.next().charAt(0);
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();
        char startChar = matrix[startRow][startCol];

        fill(startRow, startCol, numRows, numCols, matrix, startChar, fillChar);

        // Print the matrix after the fill operation
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner scanner, int numRows, int numCols, char[][] matrix) {
        // Read the matrix from input
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = scanner.next().charAt(0);
            }
        }
    }

    private static void fill(int row, int col, int numRows, int numCols, char[][] matrix, char startChar, char fillChar) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || matrix[row][col] != startChar) {
            // Stop recursion if we're out of bounds or if we've reached a different character
            return;
        }

        // Change the current character to the fill character
        matrix[row][col] = fillChar;

        // Recursively call fill() for each adjacent cell
        fill(row - 1, col, numRows, numCols, matrix, startChar, fillChar);
        fill(row + 1, col, numRows, numCols, matrix, startChar, fillChar);
        fill(row, col - 1, numRows, numCols, matrix, startChar, fillChar);
        fill(row, col + 1, numRows, numCols, matrix, startChar, fillChar);
    }
}

