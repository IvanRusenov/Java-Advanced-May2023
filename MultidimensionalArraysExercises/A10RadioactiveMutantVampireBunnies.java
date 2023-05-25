package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A10RadioactiveMutantVampireBunnies {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = coordinates[0];
        int cols = coordinates[1];

        String[][] lair = new String[rows][cols];

        fill(lair, scan);

        String commands = scan.nextLine();
        boolean isPlayerDead = false;
        boolean isPlayerWins = false;
        int playerLastRow = 0;
        int playerLastCol = 0;
        int[] playersCoordinates = playersCoordinates(lair);
        int playersRow = playersCoordinates[0];
        int playersCol = playersCoordinates[1];

        for (int i = 0; i < commands.length(); i++) {

            if (isPlayerDead || isPlayerWins) {

                break;

            }

            String playersNextMove = commands.charAt(i) + "";

            switch (playersNextMove) {

                case "L":

                    if (playersCol - 1 < 0) {

                        isPlayerWins = true;
                        lair[playersRow][playersCol] = ".";

                    } else if (lair[playersRow][playersCol - 1].equals("B")) {

                        isPlayerDead = true;
                        lair[playersRow][playersCol] = ".";
                        playersCol--;

                    } else if (lair[playersRow][playersCol - 1].equals(".")) {

                        lair[playersRow][playersCol] = ".";
                        playersCol--;
                        lair[playersRow][playersCol] = "P";

                    }

                    playerLastRow = playersRow;
                    playerLastCol = playersCol;
                    break;

                case "R":

                    if (playersCol + 1 == cols) {

                        isPlayerWins = true;
                        lair[playersRow][playersCol] = ".";

                    } else if (lair[playersRow][playersCol + 1].equals("B")) {

                        isPlayerDead = true;
                        lair[playersRow][playersCol] = ".";
                        playersCol++;

                    } else if (lair[playersRow][playersCol + 1].equals(".")) {

                        lair[playersRow][playersCol] = ".";
                        playersCol++;
                        lair[playersRow][playersCol] = "P";

                    }

                    playerLastRow = playersRow;
                    playerLastCol = playersCol;
                    break;

                case "U":

                    if (playersRow - 1 < 0) {

                        isPlayerWins = true;
                        lair[playersRow][playersCol] = ".";

                    } else if (lair[playersRow - 1][playersCol].equals("B")) {

                        isPlayerDead = true;
                        lair[playersRow][playersCol] = ".";
                        playersRow--;

                    } else if (lair[playersRow - 1][playersCol].equals(".")) {

                        lair[playersRow][playersCol] = ".";
                        playersRow--;
                        lair[playersRow][playersCol] = "P";

                    }

                    playerLastRow = playersRow;
                    playerLastCol = playersCol;
                    break;

                case "D":

                    if (playersRow + 1 == rows) {

                        isPlayerWins = true;
                        lair[playersRow][playersCol] = ".";

                    } else if (lair[playersRow + 1][playersCol].equals("B")) {

                        isPlayerDead = true;
                        lair[playersRow][playersCol] = ".";
                        playersRow++;

                    } else if (lair[playersRow + 1][playersCol].equals(".")) {

                        lair[playersRow][playersCol] = ".";
                        playersRow++;
                        lair[playersRow][playersCol] = "P";

                    }

                    playerLastRow = playersRow;
                    playerLastCol = playersCol;
                    break;

            }

            List<int[]> bCoordinatesList = findBunnies(lair);

            for (int[] rowCol : bCoordinatesList) {

                int bRow = rowCol[0];
                int bCol = rowCol[1];

                if (bRow - 1 >= 0) {

                    if (lair[bRow - 1][bCol].equals("P")) {

                        isPlayerDead = true;

                    }

                    lair[bRow - 1][bCol] = "B";

                }

                if (bCol - 1 >= 0) {

                    if (lair[bRow][bCol - 1].equals("P")) {

                        isPlayerDead = true;

                    }

                    lair[bRow][bCol - 1] = "B";

                }

                if (bRow + 1 < lair.length) {

                    if (lair[bRow + 1][bCol].equals("P")) {

                        isPlayerDead = true;

                    }

                    lair[bRow + 1][bCol] = "B";

                }

                if (bCol + 1 < cols) {

                    if (lair[bRow][bCol + 1].equals("P")) {

                        isPlayerDead = true;

                    }

                    lair[bRow][bCol + 1] = "B";

                }

            }

        }


        printLair(lair);

        if (isPlayerDead) {

            System.out.printf("dead: %d %d\n", playerLastRow, playerLastCol);

        } else {

            System.out.printf("won: %d %d\n", playerLastRow, playerLastCol);

        }

    }

    private static void fill(String[][] lair, Scanner scanner) {

        for (int row = 0; row < lair.length; row++) {

            lair[row] = scanner.nextLine().split("|");

        }

    }

    private static int[] playersCoordinates(String[][] lair) {

        int[] playersCoordinates = new int[2];

        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {

                if (lair[i][j].equals("P")) {

                    playersCoordinates[0] = i;
                    playersCoordinates[1] = j;
                    return playersCoordinates;

                }
            }
        }

        return playersCoordinates;

    }

    private static void printLair(String[][] lair) {

        for (String[] strings : lair) {

            for (String string : strings) {

                System.out.printf("%s", string);

            }

            System.out.println();

        }
    }

    private static List<int[]> findBunnies(String[][] lair) {

        List<int[]> bCoordinatesList = new ArrayList<>();

        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {

                if (lair[i][j].equals("B")) {

                    int[] bCoordinates = new int[2];
                    bCoordinates[0] = i;
                    bCoordinates[1] = j;
                    bCoordinatesList.add(bCoordinates);

                }
            }
        }

        return bCoordinatesList;
    }

}
