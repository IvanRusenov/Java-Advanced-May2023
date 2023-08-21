package JavaAdvancedExam26June2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A02Python {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int pythonLength = 1;
        int size = Integer.parseInt(scan.nextLine());

        String[][] field = new String[size][];

        List<String> commands = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        int pythonRow = -1;
        int pythonCol = -1;
        int foodCount = 0;

        for (int i = 0; i < size; i++) {

            field[i] = scan.nextLine().split("\\s+");

            for (int j = 0; j < field[i].length; j++) {

                if (field[i][j].equals("s")) {

                    pythonRow = i;
                    pythonCol = j;

                } else if (field[i][j].equals("f")) {

                    foodCount++;

                }

            }
        }

        for (String command : commands) {

            switch (command) {
                case "up":

                    if (pythonRow - 1 < 0) {
                        pythonRow = size - 1;
                    } else {
                        pythonRow--;
                    }

                    break;

                case "down":

                    if (pythonRow + 1 >= size) {

                        pythonRow = 0;

                    } else {

                        pythonRow++;

                    }

                    break;

                case "left":

                    if (pythonCol - 1 < 0) {

                        pythonCol = size - 1;

                    } else {

                        pythonCol--;

                    }

                    break;

                case "right":

                    if (pythonCol + 1 >= size) {

                        pythonCol = 0;

                    } else {

                        pythonCol++;

                    }

                    break;
            }

            if (field[pythonRow][pythonCol].equals("f")) {

                field[pythonRow][pythonCol] = "*";
                pythonLength++;
                foodCount--;

                if (0 == foodCount) {

                    System.out.printf("You win! Final python length is %d\n", pythonLength);
                    return;

                }

            } else if (field[pythonRow][pythonCol].equals("e")) {

                System.out.println("You lose! Killed by an enemy!");
                return;

            }

        }

        System.out.printf("You lose! There is still %d food to be eaten.\n", foodCount);

    }
}
