package JavaAdvancedRetakeExam18August2021;

import java.util.Scanner;

public class A02FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int count = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("P")) {
                    playerRow = i;
                    playerCol = j;
                    matrix[playerRow][playerCol] = ".";
                }
            }
        }

        boolean isF = false;
        String command = scan.nextLine();
        while (count-- > 0) {


            switch (command) {
                case "up":
                    if (playerRow - 1 < 0) {
                        playerRow = rows - 1;
                    } else {
                        playerRow--;
                        if (matrix[playerRow][playerCol].equals("B")) {
                            command = "up";
                            count++;
                            continue;
                        } else if (matrix[playerRow][playerCol].equals("T")) {
                            playerRow++;
                        }
                    }
                    break;
                case "down":
                    if (playerRow + 1 >= rows) {
                        playerRow = 0;
                    } else {
                        playerRow++;
                        if (matrix[playerRow][playerCol].equals("B")) {
                            command = "down";
                            count++;
                            continue;
                        } else if (matrix[playerRow][playerCol].equals("T")) {
                            playerRow--;
                        }
                    }
                    break;
                case "left":
                    if (playerCol - 1 < 0) {
                        playerCol = matrix[playerRow].length - 1;
                    } else {
                        playerCol--;
                        if (matrix[playerRow][playerCol].equals("B")) {
                            command = "left";
                            count++;
                            continue;
                        } else if (matrix[playerRow][playerCol].equals("T")) {
                            playerCol++;
                        }
                    }
                    break;
                case "right":
                    if (playerCol + 1 >= matrix[playerRow].length) {
                        playerCol = 0;
                    } else {
                        playerCol++;
                        if (matrix[playerRow][playerCol].equals("B")) {
                            command = "right";
                            count++;
                            continue;
                        } else if (matrix[playerRow][playerCol].equals("T")) {
                            playerCol--;
                        }
                    }
                    break;
            }

            if (matrix[playerRow][playerCol].equals("F")) {
                isF = true;
                break;
            }

            if (count > 0) {
                command = scan.nextLine();
            }


        }
        matrix[playerRow][playerCol] = "P";
        if (isF) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[playerRow].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
