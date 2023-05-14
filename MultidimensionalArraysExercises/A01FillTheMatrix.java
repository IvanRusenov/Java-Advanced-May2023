package MultidimensionalArraysExercises;

import java.util.Scanner;

public class A01FillTheMatrix {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[size][size];

        if (type.equals("A")) {

            fillA(matrix);

        } else if (type.equals("B")) {

            fillB(matrix);

        }

        printMatrix(matrix);

    }

    private static void fillA(int[][] matrix) {

        int num = 1;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                matrix[j][i] = num;
                num++;

            }
        }

    }

    private static void fillB(int[][] matrix) {

        int num = 1;

        for (int col = 0; col < matrix.length; col++) {

            if (col % 2 == 0) {

                for (int row = 0; row < matrix.length; row++) {

                    matrix[row][col] = num;
                    num++;

                }

            } else {

                for (int row = matrix.length - 1; row >= 0; row--) {

                    matrix[row][col] = num;
                    num++;

                }

            }
        }

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
