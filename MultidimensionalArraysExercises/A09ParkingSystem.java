package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class A09ParkingSystem {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        boolean[][] parking = new boolean[rows][cols];

        String input = scan.nextLine();

        while (!input.equals("stop")) {

            String[] coordinates = input.split("\\s+");

            int entryRow = Integer.parseInt(coordinates[0]);
            int rowToPark = Integer.parseInt(coordinates[1]);
            int colToPark = Integer.parseInt(coordinates[2]);
            int traveledDistance = Integer.MAX_VALUE;

            if (!parking[rowToPark][colToPark]) {

                parking[rowToPark][colToPark] = true;
                traveledDistance = Math.abs(rowToPark - entryRow) + colToPark + 1;

            } else {

                if (nearestFreePlace(parking, rowToPark,colToPark,cols) > 0){

                    colToPark = nearestFreePlace(parking, rowToPark,colToPark,cols);
                    traveledDistance = Math.abs(rowToPark - entryRow) + colToPark + 1;
                    parking[rowToPark][colToPark] = true;

                }

            }

            if (traveledDistance == Integer.MAX_VALUE) {

                System.out.printf("Row %d full\n", rowToPark);

            } else {

                System.out.println(traveledDistance);

            }

            input = scan.nextLine();

        }

    }

    private static int nearestFreePlace(boolean[][]parking, int rowToPark, int colToPark, int cols){

        //left from target place
        boolean isFoundLeft = false;
        int freePlaceLeft = 0;
        int count = 0;
        int distanceToOriginLeft = 0;

        for (int col = colToPark -1; col > 0 ; col--) {
            count++;
            if (!parking[rowToPark][col]){
                isFoundLeft = true;
                freePlaceLeft = col;
                distanceToOriginLeft = count;
                break;
            }
        }

        //right from target place
        int distanceToOriginRight = 0;
        int freePlaceRight = 0;
        count = 0;
        boolean isFoundRight = false;

        for (int col = colToPark+1; col < cols ; col++) {
            count++;
            if (!parking[rowToPark][col]){
                freePlaceRight = col;
                distanceToOriginRight = count;
                isFoundRight = true;
                break;
            }
        }
            if (isFoundLeft && !isFoundRight){
                return freePlaceLeft;
            } else if (isFoundRight && !isFoundLeft) {
                return freePlaceRight;
            } else if (isFoundRight) {
                if (distanceToOriginLeft <= distanceToOriginRight){

                    return freePlaceLeft;// free coll left index

                } else {

                    return freePlaceRight;// free col right index

                }

            }else {
                return -1;
            }

    }



}
