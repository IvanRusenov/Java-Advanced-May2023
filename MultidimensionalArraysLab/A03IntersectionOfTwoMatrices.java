package MultidimensionalArraysLab;

import java.util.Scanner;

public class A03IntersectionOfTwoMatrices {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] first = new char[rows][];
        char[][] second = new char[rows][];
        char[][] result = new char[rows][cols];

        first = fillMatrix(rows, cols, first, scan);
        second =  fillMatrix(rows, cols, second, scan);

        compareElements(rows, cols, first, second, result);

        printResultMatrix(rows, cols, result);


    }

    private static void printResultMatrix(int rows, int cols, char[][] result) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%c ", result[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] compareElements(int rows, int cols, char[][] first, char[][] second, char[][] result) {


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (first[i][j] == second[i][j]){
                    result[i][j] = first[i][j];
                }else {
                    result[i][j] = '*';
                }

            }
        }
        return result;

    }

    private static char[][] fillMatrix(int rows, int cols, char[][] matrix, Scanner scan) {

        for (int i = 0; i < rows; i++) {

            matrix[i] = scan.nextLine().replace(" ", "").toCharArray();

        }
        return  matrix;
    }




}
