package JavaAdvancedExam20February2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A02Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        List<String> directions = Arrays.stream(scan.nextLine().split(",")).collect(Collectors.toList());

        String [][] field = new String[size][];
        int row = -1;
        int col = -1;
        boolean isFound = false;
        int bombsFound = 0;
        int bombsCount = 0;

        for (int i = 0; i < size; i++) {

            field[i] = scan.nextLine().split("\\s+");

            for (int j = 0; j < field[i].length; j++) {

                if (field[i][j].equals("s")){

                    row = i;
                    col = j;
                   
                } else if (field[i][j].equals("B")) {

                    bombsCount++;

                }
            }
        }

boolean isEnd = false;
        for (String direction : directions) {
            switch (direction){
                case "up":
                    if (row - 1 >=0){
                        row--;
                    }
                    break;
                case "down":
                    if (row + 1 < size){
                        row++;
                    }
                    break;
                case "left":
                    if (col - 1 >=0){
                        col--;
                    }
                    break;
                case "right":
                    if (col + 1 < field[row].length){
                        col++;
                    }
                    break;
            }

            if (field[row][col].equals("B")){

                System.out.println("You found a bomb!");
                bombsFound++;
                field[row][col] = "+";
                if (bombsFound == bombsCount){
                    break;
                }
               
            }else if (field[row][col].equals("e")){
                isEnd = true;
                break;
            }

        }

        if (bombsFound == bombsCount){
            System.out.println("Congratulations! You found all bombs!");
        }else if(isEnd){
            System.out.printf("END! %d bombs left on the field\n", bombsCount - bombsFound);
        }else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n", bombsCount-bombsFound, row, col);
        }



    }
}
