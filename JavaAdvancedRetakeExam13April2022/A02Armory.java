package JavaAdvancedRetakeExam13April2022;

import java.util.List;
import java.util.Scanner;

public class A02Armory {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split("");
        }


        int officerRow = -1;
        int officerCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("A")) {
                    officerRow = i;
                    officerCol = j;
                    matrix[officerRow][officerCol] = "-";
                }
            }
        }

        List<String> numbers = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        int blades = 0;
        boolean isOut = false;
        boolean isEnoughBlades = false;

        while (true){

            String direction = scan.nextLine();
            matrix[officerRow][officerCol] = "-";

                switch (direction){
                case "up":
                    if (officerRow -1 < 0){
                        isOut = true;

                    }else {

                        officerRow--;
                    }
                    break;
                case "down":
                    if (officerRow + 1 >= n){
                        isOut =true;
                    }else{

                        officerRow++;

                    }
                    break;
                case "left":
                    if (officerCol - 1 < 0){
                        isOut = true;
                    }else {

                        officerCol--;
                    }
                    break;
                case "right":
                    if (officerCol + 1 >= n){
                        isOut = true;
                    }else {

                        officerCol++;
                    }
                    break;
            }

            if (isOut){
                break;
            }


           if (numbers.contains(matrix[officerRow][officerCol])){

                blades += Integer.parseInt(matrix[officerRow][officerCol]);
               matrix[officerRow][officerCol] = "A";

            } else if (matrix[officerRow][officerCol].equals("M")) {

                matrix[officerRow][officerCol] = "-";

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j].equals("M")){
                            officerRow = i;
                            officerCol = j;
                            matrix[officerRow][officerCol] = "A";
                        }
                    }
                }

            }



            if (blades >= 65){
                isEnoughBlades = true;
                break;
            }


        }


        if (isEnoughBlades){
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.\n", blades);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }



    }
}
