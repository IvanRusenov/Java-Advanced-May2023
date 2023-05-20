package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A05MatrixShuffling3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = new int[2];

        try {

            dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        } catch (NumberFormatException e) {

            System.out.println("Invalid input!");
            return;
        }

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] command = input.split("\\s+");

            try {

                if (!command[0].equals("swap") || command.length != 5) {

                    throw new IllegalArgumentException("Invalid input!");

                }

                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                if (!isValidIndexes(row1, col1, row2, col2, rows, cols)) {

                    throw new IllegalArgumentException("Invalid input!");

                }

                String element = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = element;
                printMatrix(matrix);

            } catch (IllegalArgumentException ex) {

                System.out.println(ex.getMessage());

            }

            input = scanner.nextLine();

        }
    }

    private static boolean isValidIndexes(int row1, int col1, int row2, int col2, int rows, int cols) {

        return (row1 >= 0 && row1 < rows)
                && (col1 >= 0 && col1 < cols)
                && (row2 >= 0 && row2 < rows)
                && (col2 >= 0 && col2 < cols);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

    }

    private static void printMatrix(String[][] matrix) {

        for (String[] row : matrix) {
            System.out.println(String.join(" ", row));
        }
    }

}
