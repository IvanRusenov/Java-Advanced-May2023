package JavaAdvancedRetakeExam14April2021;

import java.util.Scanner;

public class A02CookingJourney {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[][] pastryShop = new String[size][];
        int row = -1;
        int col = -1;
        boolean isFound = false;

        for (int i = 0; i < size; i++) {

            pastryShop[i] = scan.nextLine().split("");

            if (!isFound){

                for (int j = 0; j < pastryShop[i].length; j++) {

                    if (pastryShop[i][j].equals("S")) {

                        row = i;
                        col = j;
                        pastryShop[i][j] = "-";
                        isFound = true;
                        break;

                    }
                }
            }


        }

        isFound = false;
        int money = 0;
        boolean isOut = false;

        while (true) {
            String command = scan.nextLine();

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

            if (col < 0 || col >= size || row < 0 || row >= size) {

                isOut = true;
                break;

            }

            if (Character.isDigit(pastryShop[row][col].charAt(0))) {

                money += Integer.parseInt(pastryShop[row][col]);
                pastryShop[row][col] = "-";

                if (money >= 50) {

                    pastryShop[row][col] = "S";
                    break;

                }

            } else if (pastryShop[row][col].equals("P")) {

                pastryShop[row][col] = "-";

                for (int i = 0; i < size; i++) {

                    for (int j = 0; j < pastryShop[i].length; j++) {

                        if (pastryShop[i][j].equals("P")) {

                            row = i;
                            col = j;
                            pastryShop[i][j] = "-";
                            isFound = true;
                            break;

                        }
                    }

                    if (isFound) {

                        break;

                    }
                }
            }
        }

        if (isOut) {

            System.out.println("Bad news! You are out of the pastry shop.");

        } else {

            System.out.println("Good news! You succeeded in collecting enough money!");

        }

        System.out.printf("Money: %d\n", money);

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < pastryShop[i].length; j++) {

                System.out.print(pastryShop[i][j]);

            }

            System.out.println();

        }

    }
}
