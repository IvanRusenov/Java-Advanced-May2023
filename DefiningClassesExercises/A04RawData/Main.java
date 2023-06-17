package DefiningClassesExercises.A04RawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {

            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Tire[] tires = new Tire[4];
            tires[0] = new Tire(tire1Age,tire1Pressure);
            tires[1] = new Tire(tire2Age,tire2Pressure);
            tires[2] = new Tire(tire3Age,tire3Pressure);
            tires[3] = new Tire(tire4Age,tire4Pressure);

            Car car = new Car(model,engine,cargo,tires);
            cars.add(car);

        }

        String command = scan.nextLine();

        if (command.equals("fragile")){

            for (Car car : cars) {

                if (car.getCargo().getType().equals("fragile")){
                    for (Tire tire : car.getTires()) {

                        if (tire.getTirePressure() < 1){
                            System.out.println(car.getModel());
                            break;
                        }

                    }
                }

            }

//            cars.stream().filter(car -> car.getCargo().getType().equals("fragile")).filter(car -> Arrays.stream(car.getTires()).filter(tire -> tire.getTirePressure() < 1)).forEach(car -> System.out.println(car.getModel()));
            
        } else if (command.equals("flamable")) {

            for (Car car : cars) {
                if (car.getCargo().getType().equals("flamable")&& car.getEngine().getPower() > 250){
                    System.out.println(car.getModel());
                }
            }
            
        }

    }
}
