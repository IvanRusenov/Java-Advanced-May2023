package DefiningClassesLab.A01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);


       int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String [] carParameters = scan.nextLine().split("\\s+");

            String brand = carParameters[0];
            String model = carParameters[1];
            int hp = Integer.parseInt(carParameters[2]);

            Car car = new Car(brand,model,hp);

            System.out.println(car.carInfo());


        }







    }
}
