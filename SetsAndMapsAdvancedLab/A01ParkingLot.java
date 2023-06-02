package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class A01ParkingLot {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scan.nextLine();

        while (!input.equals("END")){

            String[] data = input.split(",\\s+");

            String action = data[0];
            String carNumber = data[1];

            if (action.equals("IN")){

                parking.add(carNumber);

            } else {

                parking.remove(carNumber);

            }

            input = scan.nextLine();

        }

        if (parking.isEmpty()){

            System.out.println("Parking Lot is Empty");

        } else {

            parking.forEach(e -> System.out.printf("%s\n",e));

        }

    }

}
