package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A09PoisonousPlants {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] plants = new int[n];

        for (int i = 0; i < n; i++) {
            plants[i] = scanner.nextInt();
        }

        int[] days = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            int day = 0;

            while (!stack.isEmpty() && plants[i] <= plants[stack.peek()]) {
                day = Math.max(day, days[stack.pop()]);
            }

            if (!stack.isEmpty()) {
                days[i] = day + 1;
            }

            stack.push(i);

        }

        int maxDays = 0;

        for (int day : days) {
            maxDays = Math.max(maxDays, day);
        }

        System.out.println(maxDays);

    }

}
