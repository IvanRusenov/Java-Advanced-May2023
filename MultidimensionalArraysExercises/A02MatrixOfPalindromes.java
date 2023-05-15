package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A02MatrixOfPalindromes {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int r = input[0];
        int c = input[1];

        String[][] matrix = new String[r][c];

        fillMatrix(matrix);

        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                StringBuilder sb = new StringBuilder();
                char firstChar = (char)(row + 97);
                char middleCharr = (char)(col + row + 97);
                char lastChar = (char)(row + 97);
                matrix[row][col] = sb.append(firstChar).append(middleCharr).append(lastChar).toString();

            }
        }
    }

    private static void printMatrix (String[][]matrix){

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.printf("%s ", matrix[i][j]);

            }

            System.out.println();

        }
    }
}
