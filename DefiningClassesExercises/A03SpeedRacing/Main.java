package DefiningClassesExercises.A03SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0){

            String[]data = scan.nextLine().split("\\s+");

            Car car = new Car();

            car.setModel(data[0]);
            car.setFuelAmount(Integer.parseInt(data[1]));
            car.setFuelPerKm(Double.parseDouble(data[2]));
            cars.add(car);

        }


        String input = scan.nextLine();


        while (!input.equals("End")){

            String[] command = input.split("\\s+");

            Car.drive(command[1], Integer.parseInt(command[2]), cars);

            input = scan.nextLine();
        }

        for (Car car : cars) {
            System.out.printf("%s %.2f %d\n"
                    , car.getModel(), car.getFuelAmount(), car.getTraveledDistance());
        }

    }
}
