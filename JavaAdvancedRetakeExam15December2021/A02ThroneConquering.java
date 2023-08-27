package JavaAdvancedRetakeExam15December2021;

import java.util.Scanner;

public class A02ThroneConquering {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //fieldOfSparta rows are with different length !!!

        int energy = Integer.parseInt(scan.nextLine());
        int rows = Integer.parseInt(scan.nextLine());
        boolean isHelenSaved = false;

        String[][] fieldOfSparta = new String[rows][];

        for (int i = 0; i < rows; i++) {

            fieldOfSparta[i] = scan.nextLine().split("");

        }

        int parisRow = -1;
        int parisCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < fieldOfSparta[i].length; j++) {

                if (fieldOfSparta[i][j].equals("P")) {
                    parisRow = i;
                    parisCol = j;
                    fieldOfSparta[parisRow][parisCol] = "-";
                }

            }
        }

        while (energy > 0 && !isHelenSaved) {

            String[] direction = scan.nextLine().trim().split("\\s+");
            int enemyRow = Integer.parseInt(direction[1]);
            int enemyCol = Integer.parseInt(direction[2]);

            fieldOfSparta[enemyRow][enemyCol] = "S";
            energy--;

            if (direction[0].equals("up")) {

                if (parisRow - 1 >= 0) {

                    parisRow--;

                } else {

                    continue;

                }

            } else if (direction[0].equals("down")) {

                if (parisRow + 1 < rows) {

                    parisRow++;

                } else {

                    continue;

                }

            } else if (direction[0].equals("left")) {

                if (parisCol - 1 >= 0) {

                    parisCol--;

                } else {

                    continue;

                }

            } else if (direction[0].equals("right")) {

                if (parisCol + 1 < fieldOfSparta[parisRow].length) {

                    parisCol++;

                } else {

                    continue;

                }

            }

            if (fieldOfSparta[parisRow][parisCol].equals("S")) {

                energy -= 2;

            } else if (fieldOfSparta[parisRow][parisCol].equals("H")) {

                isHelenSaved = true;

            }

            fieldOfSparta[parisRow][parisCol] = "-";

        }

        if (isHelenSaved) {

            System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);

        } else {

            fieldOfSparta[parisRow][parisCol] = "X";
            System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);

        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < fieldOfSparta[i].length; j++) {

                System.out.print(fieldOfSparta[i][j]);

            }

            System.out.println();
        }

    }
}
