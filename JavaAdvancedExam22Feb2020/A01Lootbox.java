package JavaAdvancedExam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A01Lootbox {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> first = new ArrayDeque<>();//queue
        ArrayDeque<Integer> second = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(first::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(second::push);

        int totalSum = 0;

        while (!first.isEmpty() && !second.isEmpty()) {

            int fItem = first.peek();
            int sItem = second.pop();
            int sum = fItem + sItem;


            if (sum % 2 == 0) {
                totalSum += sum;
                first.poll();
            } else {
                first.offer(sItem);
            }


        }

        if (first.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (second.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (totalSum >= 100) {
            System.out.printf("Your loot was epic! Value: %d\n", totalSum);
        } else {
            System.out.printf("Your loot was poor... Value: %d\n", totalSum);
        }


    }
}
