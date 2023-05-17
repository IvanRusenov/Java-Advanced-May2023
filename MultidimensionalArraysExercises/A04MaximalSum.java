package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A04MaximalSum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[input[0]][input[1]];

        fillMatrix(matrix, scan);

        int[][] biggestSumMatrix3x3 = matrix3x3WithBiggestSum(matrix);

        System.out.printf("Sum = %d\n", sum3x3Matrix(biggestSumMatrix3x3));

        printMatrix(biggestSumMatrix3x3);

    }

    private static void fillMatrix(int[][] matrix, Scanner scan) {

        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
    }

    private static int[][] matrix3x3WithBiggestSum(int[][] matrix) {

        int biggestSum = Integer.MIN_VALUE;
        int[][] biggestSumMatrix3x3 = new int[3][3];

        for (int row = 1; row < matrix.length - 1; row++) {

            for (int col = 1; col < matrix[row].length - 1; col++) {

                int[][] matrix3x3 = fillMatrix3x3(matrix, row, col);

                if (sum3x3Matrix(matrix3x3) > biggestSum) {

                    biggestSum = sum3x3Matrix(matrix3x3);
                    biggestSumMatrix3x3 = matrix3x3;

                }

            }

        }

        return biggestSumMatrix3x3;

    }

    private static int[][] fillMatrix3x3(int[][] matrix, int r, int c) {

        int[][] matrix3x3 = new int[3][3];

        for (int i = 0; i < matrix3x3.length; i++) {

            for (int j = 0; j < matrix3x3[i].length; j++) {

                matrix3x3[i][j] = matrix[r - 1 + i][c - 1 + j];

            }
        }

        return matrix3x3;

    }

    private static int sum3x3Matrix(int[][] matrix3x3) {

        int sum = 0;

        for (int i = 0; i < matrix3x3.length; i++) {

            for (int j = 0; j < matrix3x3[i].length; j++) {

                sum += matrix3x3[i][j];

            }
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
