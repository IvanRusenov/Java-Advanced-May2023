package JavaAdvancedRetakeExam12April2023;

import java.util.Scanner;

public class A02TheSquirrel {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int collectedHazelnut = 0;

        int size = Integer.parseInt(scan.nextLine());
        String[] directions = scan.nextLine().split(",\\s+");

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].equals("s")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
        boolean isInTrap = false;
        boolean isOut = false;
        for (String direction : directions) {

            matrix[currentRow][currentCol] = "*";

            switch (direction) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;

            }


            if (isInMatrix(currentRow, currentCol, size)) {

                if (matrix[currentRow][currentCol].equals("h")) {
                    collectedHazelnut++;
                    matrix[currentRow][currentCol] = "*";
                    if (collectedHazelnut == 3) {
                        break;
                    }
                } else if (matrix[currentRow][currentCol].equals("t")) {
                    matrix[currentRow][currentCol] = "*";
                    isInTrap = true;
                    break;
                }

            } else {


                isOut = true;
                break;

            }


        }

        if (isOut) {

            System.out.println("The squirrel is out of the field.");

        } else if (isInTrap) {

            System.out.println("Unfortunately, the squirrel stepped on a trap...");

        } else {

            if (collectedHazelnut == 3) {

                System.out.println("Good job! You have collected all hazelnuts!");

            } else {
                System.out.println("There are more hazelnuts to collect.");
            }
        }

        System.out.printf("Hazelnuts collected: %d\n", collectedHazelnut);


    }

    public static boolean isInMatrix(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
