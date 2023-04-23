package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A02BasicStackOperations {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int elementsToPush = input[0];
        int elementsToPop = input[1];
        int elementToCheckIsPresent = input[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < elementsToPush; i++) {

            stack.push(numbers[i]);

        }

        while (elementsToPop-- > 0) {

            stack.pop();

        }

        if (stack.isEmpty()) {

            System.out.println("0");

        } else if (stack.contains(elementToCheckIsPresent)) {

            System.out.println("true");

        } else {

            System.out.println(stack.stream().mapToInt(i -> i).min().getAsInt());

        }

    }

}

