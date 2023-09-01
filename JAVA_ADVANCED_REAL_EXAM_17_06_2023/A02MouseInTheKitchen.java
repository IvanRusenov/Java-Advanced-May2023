package JAVA_ADVANCED_REAL_EXAM_17_06_2023;

import java.util.Scanner;

public class A02MouseInTheKitchen {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] cupboard = new String[rows][cols];

        int row = -1;
        int col = -1;
        int cheesesCount = 0;
        int cheesesEaten = 0;


        for (int i = 0; i < rows; i++) {

            cupboard[i] = scan.nextLine().split("");

            for (int j = 0; j < cols; j++) {

                if (cupboard[i][j].equals("M")) {

                    row = i;
                    col = j;
                    cupboard[row][col] = "*";

                } else if (cupboard[i][j].equals("C")) {

                    cheesesCount++;

                }
            }
        }

        String command = scan.nextLine();
        boolean isOut = false;
        boolean isSleep = false;
        boolean isTrapped = false;

        while (!command.equals("danger")) {

            int lastRow = row;
            int lastCol = col;

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

            if (row < 0 || row >= rows || col < 0 || col >= cols) {

                isOut = true;
                cupboard[lastRow][lastCol] = "M";
                break;

            } else if (cupboard[row][col].equals("T")) {

                cupboard[row][col] = "M";
                isTrapped = true;
                break;

            } else if (cupboard[row][col].equals("@")) {

                row = lastRow;
                col = lastCol;

            } else if (cupboard[row][col].equals("C")) {

                cheesesEaten++;

                if (cheesesEaten >= cheesesCount) {

                    isSleep = true;
                    cupboard[row][col] = "M";
                    break;

                } else {

                    cupboard[row][col] = "*";

                }

            }

            command = scan.nextLine();

        }

        if (isOut) {

            System.out.println("No more cheese for tonight!");

        } else if (isTrapped) {

            System.out.println("Mouse is trapped!");

        } else if (isSleep) {

            System.out.println("Happy mouse! All the cheese is eaten, good night!");

        } else if (cheesesEaten < cheesesCount) {

            System.out.println("Mouse will come back later!");
            cupboard[row][col] = "M";

        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(cupboard[i][j]);

            }

            System.out.println();

        }

    }
}
