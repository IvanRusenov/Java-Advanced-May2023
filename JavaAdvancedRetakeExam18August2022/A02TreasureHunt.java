package JavaAdvancedRetakeExam18August2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A02TreasureHunt {

    //TODO!!! Wrong test No 4 in judge - different rows length!

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String dimensions = scan.nextLine().trim();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {

            matrix[i] = scan.nextLine().trim().split("\\s+");

        }

        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equals("Y")) {
                    currentRow = i;
                    currentCol = j;
                }

            }
        }

        List<String> steps = new ArrayList<>();

        String direction = scan.nextLine();

        while (!direction.equals("Finish")) {

            switch (direction) {

                case "up":

                    if (isInField(matrix, currentRow - 1, currentCol) && !matrix[currentRow - 1][currentCol].equals("T")) {

                        currentRow--;
                        steps.add(direction);

                    }

                    break;

                case "down":

                    if (isInField(matrix, currentRow + 1, currentCol) && !matrix[currentRow + 1][currentCol].equals("T")) {

                        currentRow++;
                        steps.add(direction);

                    }

                    break;

                case "left":

                    if (isInField(matrix, currentRow, currentCol - 1) && !matrix[currentRow][currentCol - 1].equals("T")) {

                        currentCol--;
                        steps.add(direction);

                    }

                    break;

                case "right":

                    if (isInField(matrix, currentRow, currentCol + 1) && !matrix[currentRow][currentCol + 1].equals("T")) {

                        currentCol++;
                        steps.add(direction);

                    }

                    break;

            }

            direction = scan.nextLine();

        }

        if (matrix[currentRow][currentCol].equals("X")) {

            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s\n", String.join(", ", steps));

        } else {

            System.out.println("The map is fake!");

        }

    }

    public static boolean isInField(String[][] matrix, int currentRow, int currentCol) {

        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;

    }
}
