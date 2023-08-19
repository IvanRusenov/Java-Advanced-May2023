package JavaAdvancedExam23October2021;

import java.util.Scanner;

public class A02MouseAndCheese {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][];

        for (int i = 0; i < size; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int mouseRow = -1;
        int mouseCol = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("M")) {
                    mouseRow = i;
                    mouseCol = j;
                }
            }
        }

        String command = scan.nextLine();
        boolean isMouseOut = false;
        int eatenCheeses = 0;

        while (!command.equals("end")) {

            matrix[mouseRow][mouseCol] = "-";

            switch (command) {

                case "up":

                    if (mouseRow - 1 >= 0) {
                        mouseRow--;
                        if (matrix[mouseRow][mouseCol].equals("B")) {
                            command = "up";
                            continue;
                        }
                    } else {
                        isMouseOut = true;
                    }

                    break;

                case "down":

                    if (mouseRow + 1 < size) {
                        mouseRow++;
                        if (matrix[mouseRow][mouseCol].equals("B")) {
                            command = "down";
                            continue;
                        }
                    } else {
                        isMouseOut = true;
                    }

                    break;

                case "left":

                    if (mouseCol - 1 >= 0) {
                        mouseCol--;
                        if (matrix[mouseRow][mouseCol].equals("B")) {
                            command = "left";
                            continue;
                        }
                    } else {
                        isMouseOut = true;
                    }
                    break;

                case "right":

                    if (mouseCol + 1 < matrix[mouseRow].length) {
                        mouseCol++;
                        if (matrix[mouseRow][mouseCol].equals("B")) {
                            command = "right";
                            continue;
                        }
                    } else {
                        isMouseOut = true;
                    }
                    break;

            }

            if (isMouseOut) {
                break;
            }

            if (matrix[mouseRow][mouseCol].equals("c")) {

                eatenCheeses++;

            }

            command = scan.nextLine();

        }

        if (isMouseOut) {
            System.out.println("Where is the mouse?");
        } else {
            matrix[mouseRow][mouseCol] = "M";
        }

        if (eatenCheeses < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - eatenCheeses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", eatenCheeses);
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }

    }
}
