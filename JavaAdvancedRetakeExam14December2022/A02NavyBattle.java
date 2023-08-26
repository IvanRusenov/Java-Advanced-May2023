package JavaAdvancedRetakeExam14December2022;

import java.util.Scanner;

public class A02NavyBattle {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][]matrix = new String[n][n];

        for (int i = 0; i < n; i++) {

            matrix[i] = scan.nextLine().split("");

        }

        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j].equals("S")){

                    currentRow = i;
                    currentCol = j;

                }
            }
        }

        String direction = scan.nextLine();
        int hittedMines = 0;

        while (!isAllCruiserDestroyed(matrix) || hittedMines <= 3){

            matrix[currentRow][currentCol] = "-";

            switch (direction){
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }
            
            if (matrix[currentRow][currentCol].equals("*")){

                hittedMines++;

                if (hittedMines==3){

                    matrix[currentRow][currentCol] = "S";
                    break;

                }

            }

            matrix[currentRow][currentCol] = "S";

            if (isAllCruiserDestroyed(matrix)){

                matrix[currentRow][currentCol] = "S";
                break;

            }

            direction = scan.nextLine();

        }

        if (isAllCruiserDestroyed(matrix)){

            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");

        }

        if (hittedMines==3){

            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", currentRow, currentCol);

        }

        printMatrix(matrix);

    }
    public static boolean isAllCruiserDestroyed(String[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equals("C")){

                    return false;

                }

            }

        }

        return true;

    }

    public  static void printMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j]);

            }

            System.out.println();

        }
    }
}
