package JavaAdvancedExam22Feb2020;

import java.util.Scanner;

public class A02ReVolt {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int count = Integer.parseInt(scan.nextLine());
        String[][] field = new String[size][];

        int row = -1;
        int col = -1;

        for (int i = 0; i < size; i++) {

            field[i] = scan.nextLine().split("");

            for (int j = 0; j < field[i].length; j++) {

                if (field[i][j].equals("f")){

                    row = i;
                    col = j;
                    field[row][col] = "-";

                }

            }
        }

        String command = scan.nextLine();
        boolean isF = false;

        for (int i = 0; i < count; i++) {

            int lastRow = row;
            int lastCol = col;

            switch (command){

                case "up":
                    if (row-1 < 0){
                        row = size-1;
                    }else {
                        row--;
                    }
                    break;
                case "down":
                    if (row + 1 >= size){
                        row = 0;
                    }else {
                        row++;
                    }
                    break;
                case "left":
                    if (col-1<0){
                        col = field[row].length - 1;
                    }else {
                        col--;
                    }
                    break;
                case "right":
                    if (col+1 >= field[row].length){
                        col = 0;
                    }else {
                        col++;
                    }
                    break;

            }

            if (field[row][col].equals("B")){

                i--;
                continue;

            } else if (field[row][col].equals("T")) {

                row = lastRow;
                col = lastCol;

            }else if (field[row][col].equals("F")){

                isF = true;
                field[row][col] = "f";
                break;

            }

            if (i != count-1){

                command =scan.nextLine();

            }

        }

        if (isF){

            System.out.println("Player won!");

        }else {

            System.out.println("Player lost!");
            field[row][col] = "f";

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < field[i].length; j++) {

                System.out.print(field[i][j]);

            }

            System.out.println();

        }

    }
}
