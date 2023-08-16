package JavaAdvancedExam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A01MagicBox {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        ArrayDeque<Integer> first = new ArrayDeque<>();//queue
        ArrayDeque<Integer> second = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(first::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(second::push);
        int totalSum = 0;
        while (!first.isEmpty() && !second.isEmpty()) {

            int el1 = first.peek();
            int el2 = second.pop();
            int sum = el1 + el2;

            if (sum % 2 == 0) {
                totalSum += sum;
                first.poll();

            } else {
                first.offer(el2);
            }

        }

        if (first.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (second.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (totalSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d\n", totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d\n", totalSum);
        }

    }
}

