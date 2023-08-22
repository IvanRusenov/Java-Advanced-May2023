package JavaAdvancedExam28June2020;

import java.util.Scanner;

public class A02Snake {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[][] territory = new String[size][];
        int row = -1;
        int col = -1;
        for (int i = 0; i < size; i++) {
            territory[i] = scan.nextLine().split("");

            for (int j = 0; j < territory[i].length; j++) {
                if (territory[i][j].equals("S")) {
                    row = i;
                    col = j;
                }
            }
        }


        String command = scan.nextLine();
        boolean isOut = false;
        int foodEaten = 0;

        while (true) {
            territory[row][col] = ".";
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;

            }

            if (row < 0 || row >= size || col < 0 || col >= territory[row].length) {
                isOut = true;
                break;
            } else if (territory[row][col].equals("*")) {
                territory[row][col] = ".";
                foodEaten++;

                if (foodEaten >= 10) {
                    break;
                }

            } else if (territory[row][col].equals("B")) {
                territory[row][col] = ".";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < territory[i].length; j++) {
                        if (territory[i][j].equals("B")) {
                            row = i;
                            col = j;
                            territory[row][col] = ".";
                        }
                    }
                }
            }else {
                territory[row][col] = ".";
            }

            command = scan.nextLine();

        }

        if (isOut){
            System.out.println("Game over!");
        }else {
            System.out.println("You won! You fed the snake.");
            territory[row][col] = "S";
        }

        System.out.printf("Food eaten: %d\n", foodEaten);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }


    }
}
