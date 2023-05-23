package MultidimensionalArraysExercises;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class A08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int rows = 15;
        int cols = 15;

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix);

        int playerCurrentRow = rows/2;
        int playerCurrentCol = cols/2;

        double playerDamage = Double.parseDouble(scan.nextLine());

        double cloudDamage = 3500.00;
        double eruptionDamage = 6000.00;

        double playerHP = 18500.00;
        double heiganHP = 3000000.00;

        boolean isHeiganDefeated = false;
        boolean isPlayerKilled = false;

        String killBySpell = null;

        int countCloud = 0;

        String input = scan.nextLine();

        while (playerHP > 0 && heiganHP > 0) {

            heiganHP -= playerDamage;
            // check if spell Plague cloud is active
            if (countCloud > 0){

                playerHP -= cloudDamage;
                countCloud--;
                if (playerHP <= 0){

                    isPlayerKilled = true;
                    killBySpell = "Cloud";

                }

            }

            if (heiganHP <= 0){

                isHeiganDefeated = true;
                //heigan is defeated
                break;

            }


            if (playerHP <= 0){

                isPlayerKilled = true;
                killBySpell = "Cloud";
                break;

            }

            String[] data = input.split("\\s+");
            String spell = data[0];
            int spellRow = Integer.parseInt(data[1]);
            int spellCol = Integer.parseInt(data[2]);

            //heigan strikes spell row col
            // markDamaged cells
            fillMatrix(matrix);

            markDamagedCells(matrix, spellRow, spellCol, rows, cols);

            // isPlayer in spell radius
            if (isPlayerInDamageRange(spellRow, spellCol, playerCurrentRow, playerCurrentCol)) {
                //if is in
                //tries to move

                if (playerCurrentRow - 1 >= 0
                        && !matrix[playerCurrentRow-1][playerCurrentCol].equals("D")){
                    //try to move up
                    // change player currentRow
                    playerCurrentRow--;

                } else if (playerCurrentCol + 1 < matrix[playerCurrentRow].length
                        && !matrix[playerCurrentRow][playerCurrentCol + 1].equals("D")) {
                    //try to move right
                    //change playerCurrentCol
                    playerCurrentCol++;
                } else if (playerCurrentRow + 1 < matrix.length
                        && !matrix[playerCurrentRow + 1][playerCurrentCol].equals("D")) {
                    //try down
                    // change player currentRow
                    playerCurrentRow++;
                }else if (playerCurrentCol - 1 >= 0
                        && !matrix[playerCurrentRow][playerCurrentCol -1].equals("D")){
                    //try left
                    //change playerCurrentCol
                    playerCurrentCol--;
                }else {

                    //if player cannot move - takes damage

                    if (spell.equals("Cloud")){

                        playerHP -= cloudDamage;
                        countCloud++;
                        
                    } else if (spell.equals("Eruption")) {

                        playerHP -= eruptionDamage;

                    }

                    if (playerHP <= 0){
                        isPlayerKilled = true;
                        killBySpell = spell;
                        break;
                    }


                }


            }


            input = scan.nextLine();
        }


        if (playerHP <= 0 ){
            isPlayerKilled = true;

        }

        //first output line

        //format output
        DecimalFormat df = new DecimalFormat("#.##");

        if (isHeiganDefeated){

            System.out.println("Heigan: Defeated!");

        }else {

            System.out.printf("Heigan: %.2f\n", heiganHP);
        }

        //second output line

        if (isPlayerKilled){

            if (killBySpell.equals("Cloud")){
                killBySpell = "Plague Cloud";
            }

            System.out.printf("Player: Killed by %s\n", killBySpell);

        } else {

            System.out.printf("Player: %s\n", df.format(playerHP));
        }

        //third output line

        System.out.printf("Final position: %d, %d\n", playerCurrentRow, playerCurrentCol);





    }

    private static boolean isPlayerInDamageRange(int spellRow, int spellCol, int playerCurrentRow, int playerCurrentCol) {

        for (int row = spellRow - 1; row <= spellRow + 1; row++) {
            for (int col = spellCol - 1; col <= spellCol + 1; col++) {

                if (playerCurrentRow == row && playerCurrentCol == col) {
                    return true;
                }

            }
        }
        return false;
    }


    private static void markDamagedCells(String[][] matrix, int spellRow, int spellCol, int rows, int cols) {

        for (int row = spellRow - 1; row <= spellRow + 1; row++) {
            for (int col = spellCol - 1; col <= spellCol + 1; col++) {

                if (isInMatrix(row, col, rows, cols)) {
                    matrix[row][col] = "D";
                }

            }
        }
    }

    private static boolean isInMatrix(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static boolean isNotWallOrDamaged(int row, int col, String[][] matrix, int rows, int cols){
         return isInMatrix(row, col, rows,cols) && !matrix[row][col].equals("D");
    }

    private static void fillMatrix(String [][] matrix){

        for (String[] strings : matrix) {
            Arrays.fill(strings, "*");
        }
    }


}
