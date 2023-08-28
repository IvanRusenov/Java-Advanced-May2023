package JavaAdvancedRetakeExam16December2020;

import java.util.Scanner;

public class A02Selling {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[][] bakery = new String[size][];
        int row = -1;
        int col = -1;

        for (int i = 0; i < size; i++) {
            bakery[i] = scan.nextLine().split("");
            for (int j = 0; j < bakery[i].length; j++) {
                if (bakery[i][j].equals("S")) {
                    row = i;
                    col = j;
                    bakery[i][j] = "-";
                }
            }
        }

        boolean isOut = false;
        int money = 0;
        while (true){
            String direction = scan.nextLine();
            switch (direction){
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
            
            if (row < 0 || row >= size || col < 0 || col >= bakery[row].length){
                isOut = true;
                break;
            } else if (Character.isDigit(bakery[row][col].charAt(0))) {
                money += Integer.parseInt(bakery[row][col]);
                bakery[row][col] = "-";
                if (money >= 50){
                    bakery[row][col] = "S";
                    break;
                }
            } else if (bakery[row][col].equals("O")) {
                bakery[row][col] = "-";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < bakery[i].length; j++) {
                        if (bakery[i][j].equals("O")){
                            row = i;
                            col = j;
                        }
                    }
                }
                bakery[row][col] = "-";
            }
        }

        if (isOut){
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d\n", money);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                System.out.print(bakery[i][j]);
            }
            System.out.println();
        }


    }
}
