package JavaAdvancedRetakeExam18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class A01KAT {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Deque<Integer> licensePlates = new ArrayDeque<>();//queue
        Deque<Integer> cars = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(licensePlates::offer);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(cars::push);

        int days = 0;
        long registeredCars = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {

            days++;
            int currentPlates = licensePlates.poll();
            int currentCars = cars.pop();

            if (currentCars > currentPlates / 2) {

                int notRegisteredCars = currentCars - (currentPlates / 2);
                cars.addLast(notRegisteredCars);
                registeredCars += currentCars - notRegisteredCars;

            } else if (currentCars < currentPlates / 2) {

                int notUsedPlates = currentPlates - (currentCars * 2);
                licensePlates.offer(notUsedPlates);
                registeredCars += currentCars;

            } else {

                registeredCars += currentCars;

            }

        }

        System.out.printf("%d cars were registered for %d days!\n", registeredCars, days);

        if (!licensePlates.isEmpty()) {
            long sum = licensePlates.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%d license plates remain!\n", sum);
        }

        if (!cars.isEmpty()) {

            long sum = cars.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%d cars remain without license plates!\n", sum);

        }

        if (cars.isEmpty() && licensePlates.isEmpty()) {

            System.out.println("Good job! There is no queue in front of the KAT!");

        }

    }
}
