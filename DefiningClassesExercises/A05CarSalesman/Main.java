package DefiningClassesExercises.A05CarSalesman;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int enginesNumber = Integer.parseInt(scan.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        while (enginesNumber-- > 0) {

            String[] engineData = scan.nextLine().split("\\s+");

            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            String displacenent = "n/a";
            String efficiency = "n/a";

            if (engineData.length == 3) {

                if (Character.isDigit(engineData[2].charAt(0))) {

                    displacenent = engineData[2];

                } else {

                    efficiency = engineData[2];

                }

            } else if (engineData.length == 4) {

                displacenent = engineData[2];
                efficiency = engineData[3];

            }

            Engine engine = new Engine(model, power, displacenent, efficiency);
            engines.add(engine);

        }

        int carsNumber = Integer.parseInt(scan.nextLine());

        while (carsNumber-- > 0) {

            String[] carData = scan.nextLine().split("\\s+");
            String model = carData[0];
            String engineModel = carData[1];
            String weight = "n/a";
            String color = "n/a";

           if (carData.length == 3) {

               if (Character.isDigit(carData[2].charAt(0))){

                   weight = carData[2];

               }else {

                   color = carData[2];

               }

            } else if (carData.length == 4) {

                weight = carData[2];
                color = carData[3];

            }

           Engine carEngine = null;

            for (Engine engine : engines) {
                if (engine.getModel().equals(engineModel)){
                    carEngine = engine;
                    Car car = new Car(model, carEngine, weight, color);
                    cars.add(car);
                    break;
                }
            }


        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }


    }
}
