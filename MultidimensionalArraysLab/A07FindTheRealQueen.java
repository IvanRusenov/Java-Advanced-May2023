package MultidimensionalArraysLab;

import java.util.Scanner;

public class A07FindTheRealQueen {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = scan.nextLine().toLowerCase().split("\\s+");

        }

        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                if (matrix[row][col].equals("q")) {

                    if (checkPath(row, col, matrix)) {

                        System.out.printf("%d %d\n", row, col);

                    }

                }
            }
        }

    }

    private static boolean checkPath(int row, int col, String[][] matrix) {

        for (int i = 0; i < col; i++) {

            if (matrix[row][i].equals("q")) {

                return false;

            }

        }

        for (int i = col + 1; i < matrix[row].length; i++) {

            if (matrix[row][i].equals("q")) {

                return false;

            }

        }

        for (int i = 0; i < row; i++) {

            if (matrix[i][col].equals("q")) {

                return false;

            }
        }

        for (int i = row + 1; i < matrix.length; i++) {

            if (matrix[i][col].equals("q")) {

                return false;

            }
        }

        int j = col - 1;

        for (int i = row - 1; i >= 0; i--) {

            if (j >= 0) {

                if (matrix[i][j].equals("q")) {

                    return false;

                }

            } else {

                break;

            }

            j--;

        }

        j = col + 1;

        for (int i = row + 1; i < matrix.length; i++) {

            if (j < matrix.length) {

                if (matrix[i][j].equals("q")) {

                    return false;

                }

            } else {

                break;

            }

            j++;

        }

        j = col - 1;

        for (int i = row + 1; i < matrix.length; i++) {

            if (j >= 0) {

                if (matrix[i][j].equals("q")) {

                    return false;

                }

            } else {

                break;

            }

            j--;

        }

        j = col + 1;

        for (int i = row - 1; i >= 0; i--) {

            if (j < matrix.length) {

                if (matrix[i][j].equals("q")) {

                    return false;

                }

            } else {

                break;

            }

            j++;

        }

        return true;

    }
}
