package JavaAdvancedExam25June2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A02StickyFingers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];

        List<String> moves = Arrays.stream(scan.nextLine().split(",")).collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }

        int dillingerRow = -1;
        int dillingerCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("D")) {
                    dillingerRow = i;
                    dillingerCol = j;
                }
            }
        }


        int money = 0;
        boolean isInJail = false;
        for (String direction : moves) {
            boolean isOut = false;
            switch (direction) {
                case "up":
                    if (dillingerRow - 1 >= 0) {
                        matrix[dillingerRow][dillingerCol] = "+";
                        dillingerRow--;
                    } else {
                        isOut = true;
                    }
                    break;
                case "down":
                    if (dillingerRow + 1 < n) {
                        matrix[dillingerRow][dillingerCol] = "+";
                        dillingerRow++;
                    } else {
                        isOut = true;
                    }
                    break;
                case "left":
                    if (dillingerCol - 1 >= 0) {
                        matrix[dillingerRow][dillingerCol] = "+";
                        dillingerCol--;
                    } else {
                        isOut = true;
                    }
                    break;
                case "right":
                    if (dillingerCol + 1 < n) {
                        matrix[dillingerRow][dillingerCol] = "+";
                        dillingerCol++;
                    } else {
                        isOut = true;
                    }
                    break;

            }

            if (isOut) {
                System.out.println("You cannot leave the town, there is police outside!");
                continue;
            }

            if (matrix[dillingerRow][dillingerCol].equals("$")) {

                matrix[dillingerRow][dillingerCol] = "+";
                money += dillingerRow * dillingerCol;
                System.out.printf("You successfully stole %d$.\n", dillingerRow * dillingerCol);

            } else if (matrix[dillingerRow][dillingerCol].equals("P")) {
                matrix[dillingerRow][dillingerCol] = "#";
                isInJail = true;
                break;
            }

            matrix[dillingerRow][dillingerCol] = "D";

        }

        if (isInJail){
            System.out.printf("You got caught with %d$, and you are going to jail.\n", money);

        }else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", money);

        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
