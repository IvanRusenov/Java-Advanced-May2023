package JavaAdvancedExam22October2022;

import java.util.Scanner;

public class A02RallyRacing {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String racingNumber = scan.nextLine();

        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        int currentRow = 0;
        int currentCol = 0;
        matrix[currentRow][currentCol] = "C";

        int km = 0;
        boolean isF = false;

        String direction = scan.nextLine();

        while (!direction.equals("End")){

            matrix[currentRow][currentCol] = ".";

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
            
            if (matrix[currentRow][currentCol].equals(".")){
                
                km += 10;
                
            } else if (matrix[currentRow][currentCol].equals("T")) {

                matrix[currentRow][currentCol] = ".";

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j].equals("T")){
                            currentRow = i;
                            currentCol = j;
                            km += 30;
                            matrix[currentRow][currentCol] = ".";


                        }
                    }
                }

            } else if (matrix[currentRow][currentCol].equals("F")) {

                isF = true;
                km += 10;
                matrix[currentRow][currentCol] = "C";
                break;

            }
            matrix[currentRow][currentCol] = "C";

            direction = scan.nextLine();


        }

        if (!isF){
            System.out.printf("Racing car %s DNF.\n", racingNumber);
        }else {
            System.out.printf("Racing car %s finished the stage!\n", racingNumber);
        }

        System.out.printf("Distance covered %d km.\n", km);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }

    
}
