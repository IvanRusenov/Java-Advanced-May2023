package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class A02PositionsOf {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] rowsCols = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsCols[0];
        int cols = rowsCols[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }

        int numberToFind = Integer.parseInt(scan.nextLine());
boolean isFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == numberToFind){
                    System.out.printf("%d %d\n", i, j);
                    isFound = true;
                }

            }
        }
        if (!isFound){
            System.out.println("not found");
        }



    }
}
