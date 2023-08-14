package JavaAdvancedExam18February2023;

import java.util.Arrays;
import java.util.Scanner;

public class A02BlindMansBuff {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {

            matrix[row] = scan.nextLine().split("\\s+");

        }

        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {


                if (matrix[i][j].equals("B")) {

                    currentRow = i;
                    currentCol = j;

                }

            }
        }

        int countMoves = 0;
        int touchedOpponents = 0;
        String direction = scan.nextLine();

        while (!direction.equals("Finish")) {

            switch (direction) {

                case "up":

                    if (currentRow - 1 >= 0 && !matrix[currentRow - 1][currentCol].equals("O")) {
                        matrix[currentRow][currentCol] = "-";
                        currentRow--;
                        countMoves++;
                    }

                    break;

                case "down":

                    if (currentRow + 1 < rows && !matrix[currentRow + 1][currentCol].equals("O")) {

                        currentRow++;
                        countMoves++;
                    }

                    break;

                case "left":

                    if (currentCol - 1 >= 0 && !matrix[currentRow][currentCol - 1].equals("O")) {
                        currentCol--;
                        countMoves++;
                    }

                    break;

                case "right":

                    if (currentCol + 1 < cols && !matrix[currentRow][currentCol + 1].equals("O")) {

                        currentCol++;
                        countMoves++;

                    }

                    break;

            }

            if (matrix[currentRow][currentCol].equals("P")) {

                touchedOpponents++;
                matrix[currentRow][currentCol] = "-";

                if (touchedOpponents == 3) {

                    break;

                }

            }

            direction = scan.nextLine();

        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, countMoves);

    }

    public static boolean isIn(int currentRow, int currentCol, int rows, int cols) {
        return currentCol >= 0 && currentCol < cols && currentRow >= 0 && currentRow < rows;
    }
}
