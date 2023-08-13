package ExamPreparation;

import java.util.Scanner;

public class A02MouseAndCheese {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int mouseRow = -1;
        int mouseCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        int cheeseEaten = 0;

        String command = scan.nextLine();

        while (!command.equals("end")) {

            matrix[mouseRow][mouseCol] = "-";

            String lastCommand = command;

            switch (command) {

                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;

            }

            if (isInBounds(mouseRow, mouseCol, size)) {

                if (matrix[mouseRow][mouseCol].equals("c")) {
                    cheeseEaten++;

                } else if (matrix[mouseRow][mouseCol].equals("B")) {

                    command = lastCommand;
                    continue;
                }
                matrix[mouseRow][mouseCol] = "M";

            } else {

                System.out.println("Where is the mouse?");
                break;

            }

            command = scan.nextLine();

        }

        if (cheeseEaten >= 5) {

            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheeseEaten);

        } else {

            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheeseEaten);
        }

        printMatrix(matrix);

    }

    public static boolean isInBounds(int mouseRow, int mouseCol, int size) {

        return mouseRow >= 0 && mouseRow < size && mouseCol >= 0 && mouseCol < size;

    }
    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.printf("%s", matrix[i][j]);

            }

            System.out.println();

        }
    }

}
