package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class A01CompareMatrices {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[][] firstMatrix = matrix(input, scan);

        input = scan.nextLine();
        int[][] secondMatrix = matrix(input, scan);

        if (firstMatrix.length != secondMatrix.length) {
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < firstMatrix.length; i++) {

            if (firstMatrix[i].length != secondMatrix[i].length) {
                System.out.println("not equal");
                return;
            }

            for (int j = 0; j < firstMatrix[i].length; j++) {

                if (firstMatrix[i][j] != secondMatrix[i][j]) {

                    System.out.println("not equal");
                    return;

                }
            }
        }

        System.out.println("equal");

    }

    public static int[][] matrix(String input, Scanner scan) {

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }

        return matrix;
    }

}
