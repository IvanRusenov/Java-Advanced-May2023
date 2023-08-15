package JavaAdvancedExam19February2022;

import java.util.Scanner;

public class A02PawnWars {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] board = new String[8][8];

        for (int i = 0; i < 8; i++) {
            board[i] = scan.nextLine().split("");
        }

        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (board[i][j].equals("w")){
                    wRow = i;
                    wCol = j;
                } else if (board[i][j].equals("b")) {
                    bRow = i;
                    bCol = j;
                }
            }
        }


        boolean isWhiteCaptureBlack = false;
        boolean isBlackCaptureWhite = false;
        boolean isWiteQueen = false;
        boolean isBlackQueen = false;


        
        while (true){

            board[wRow][wCol] = "-";
            //w
            if (wRow - 1 > 0 && wCol - 1 >= 0 && board[wRow-1][wCol-1].equals("b")){
                wRow--;
                wCol--;
                isWhiteCaptureBlack = true;

            } else if (wRow - 1 > 0 && wCol + 1 < 8 && board[wRow-1][wCol+1].equals("b") ) {
                wRow--;
                wCol++;
                isWhiteCaptureBlack = true;
            }else if (wRow - 1 == 0) {
                wRow--;
                isWiteQueen = true;
            }else {
                wRow--;
            }

            board[wRow][wCol] = "w";

            if (isWhiteCaptureBlack || isWiteQueen){
                break;
            }

            //b
            board[bRow][bCol] = "-";
            if (bRow + 1 < 7 && bCol - 1 >= 0 && board[bRow+1][bCol-1].equals("w")){
                isBlackCaptureWhite = true;
                bRow++;
                bCol--;
            } else if (bRow + 1 < 7 && bCol + 1 < 8 && board[bRow + 1][bCol + 1].equals("w")) {
                isBlackCaptureWhite = true;
                bRow++;
                bCol++;
            } else if (bRow + 1 == 7) {
                isBlackQueen = true;
                bRow++;
            }else {
                bRow++;
            }
            board[bRow][bCol] = "b";

            if (isBlackCaptureWhite || isBlackQueen){
                break;
            }


        }

        if (isWhiteCaptureBlack){
            System.out.printf("Game over! White capture on %c%d.\n",wCol + 97, 8 - wRow);
        } else if (isBlackCaptureWhite) {
            System.out.printf("Game over! Black capture on %c%d.\n",  bCol + 97, 8 - bRow);
        } else if (isWiteQueen) {
            System.out.printf("Game over! White pawn is promoted to a queen at %c%d.\n", wCol + 97, 8 - wRow);
        } else {
            System.out.printf("Game over! Black pawn is promoted to a queen at %c%d.\n", bCol + 97, 8 - bRow);
        }
    }
}
