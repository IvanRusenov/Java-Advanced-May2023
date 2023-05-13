package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class A08WrongMeasurements {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[size][];

        for (int i = 0; i < size; i++) {

            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }


        int[] wrongValueCoordinates = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int wrongValue = matrix[wrongValueCoordinates[0]][wrongValueCoordinates[1]];
        int[][] resultMatrix = new int[size][];

        for (int i = 0; i < size; i++) {

            resultMatrix[i] = new int[matrix[i].length];

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == wrongValue) {

                    resultMatrix[i][j] = changeWrongValues(i, j, matrix, wrongValue);

                } else {

                    resultMatrix[i][j] = matrix[i][j];

                }

            }
        }

        printMatrix(resultMatrix);

    }

    private static int changeWrongValues(int row, int col, int[][] matrix, int wrongValue) {


        int sum = 0;
        int i = row;
        int j = col;

        if (i - 1 >= 0 && matrix[i - 1][j] != wrongValue) {

            sum += matrix[i - 1][j];

        }

        if (i + 1 < matrix.length && matrix[i + 1][j] != wrongValue) {

            sum += matrix[i + 1][j];

        }

        if (j - 1 >= 0 && matrix[i][j - 1] != wrongValue) {

            sum += matrix[i][j - 1];

        }


        if (j + 1 < matrix[i].length && matrix[i][j + 1] != wrongValue) {

            sum += matrix[i][j + 1];

        }

        return sum;


    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {


                System.out.printf("%d ", matrix[i][j]);

            }

            System.out.println();

        }

    }

}
