package DefiningClassesLab.A02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {

            String[] carData = scan.nextLine().split("\\s+");


            Car car = new Car();


            if (carData.length == 1) {
                car.setBrand(carData[0]);
            } else if (carData.length == 2) {

                car.setBrand(carData[0]);
                car.setModel(carData[1]);

            } else if (carData.length == 3) {

                car.setBrand(carData[0]);
                car.setModel(carData[1]);
                car.setHp(Integer.parseInt(carData[2]));

            }

            cars.add(car);

        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }


    }
}
