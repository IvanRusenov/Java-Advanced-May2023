package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class A06PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {

            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }


        for (int i = 0; i < size; i++) {

            System.out.printf("%d ", matrix[i][i]);

        }

        System.out.println();

        int j = 0;

        for (int i = size - 1; i >= 0; i--) {

            System.out.printf("%d ", matrix[i][j]);
            j++;

        }

    }
}
