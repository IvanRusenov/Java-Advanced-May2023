package JavaAdvancedRetakeExam19August2020;

import java.util.Scanner;

public class A02Bee {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[][] territory = new String[size][];
        int row = -1;
        int col = -1;

        for (int i = 0; i < size; i++) {
            territory[i] = scan.nextLine().split("");
            for (int j = 0; j < territory[i].length;j++) {
                if (territory[i][j].equals("B")){
                    row = i;
                    col = j;
                    territory[row][col] = ".";
                }
            }
        }
        boolean isOut = false;
        String command = scan.nextLine();
        int pollinatedFlowers = 0;

        while (!command.equals("End")){

            switch (command){
                case "up":
                    row--;
                    break;
                case "down":
                   row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            
            if (row < 0 || col < 0 || row >= size || col >= territory[row].length){
                isOut = true;
                break;
            } else if (territory[row][col].equals("O")) {
                territory[row][col] = ".";
                continue;
            } else if (territory[row][col].equals("f")) {
                pollinatedFlowers++;
                territory[row][col] = ".";
            }

            command = scan.nextLine();
        }

        if (isOut){
            System.out.println("The bee got lost!");
        }else {
            territory[row][col] = "B";
        }
        if (pollinatedFlowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 -pollinatedFlowers);
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }

    }
}
