package JavaAdvancedExam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A01EnergyDrinks {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> caffeines = new ArrayDeque<>();//stack
        ArrayDeque<Integer> drinks = new ArrayDeque<>();//queue

        Arrays.stream(scan.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(caffeines::push);
        Arrays.stream(scan.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(drinks::offer);


        int totalCaffeine = 0;

        while (!caffeines.isEmpty() && !drinks.isEmpty() && totalCaffeine<=300) {

            int coffein = caffeines.pop();
            int drink = drinks.poll();
            int result = coffein * drink;

            if (result + totalCaffeine <= 300) {
                totalCaffeine += result;
            } else {
                drinks.offer(drink);
                totalCaffeine -= 30;
                if (totalCaffeine < 0) {
                    totalCaffeine = 0;
                }
            }


        }

        if (drinks.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {

            System.out.printf("Drinks left: %s\n", drinks.stream().map(e -> e + "").collect(Collectors.joining(", ")));


        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.\n", totalCaffeine);


    }


}
