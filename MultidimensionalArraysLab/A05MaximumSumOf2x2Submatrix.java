package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class A05MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] rowsCols = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsCols[0];
        int cols = rowsCols[1];
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] subMatrix = new int[2][2];
        int[][] biggestSumMatrix = new int[2][2];
        int biggestSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j < cols-1; j++) {

                subMatrix[0][0] = matrix[i][j];
                subMatrix[1][0] = matrix[i+1][j];
                subMatrix[0][1] = matrix[i][j+1];
                subMatrix[1][1] = matrix[i+1][j+1];

                int sum =  subMatrix[0][0] +  subMatrix[1][0] + subMatrix[0][1] + subMatrix[1][1];

                if (biggestSum < sum){

                    biggestSum = sum;

                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                            biggestSumMatrix[k][l] = subMatrix[k][l];
                        }
                    }

                }

            }

        }

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                System.out.printf("%d ", biggestSumMatrix[i][j]);

            }

            System.out.println();

        }

        System.out.println(biggestSum);

    }
}
