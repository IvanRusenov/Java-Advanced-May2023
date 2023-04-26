package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class A04BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int elementsToAdd = commands[0];
        int elementsToRemove = commands[1];
        int elementToCheck = commands[2];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < elementsToAdd; i++) {

            queue.offer(input[i]);

        }

        while (elementsToRemove-- > 0) {

            queue.poll();
        }

        if (queue.isEmpty()) {

            System.out.println(0);

        } else if (queue.contains(elementToCheck)) {

            System.out.println(true);

        } else {

            System.out.println(queue.stream().mapToInt(i -> i).min().getAsInt());

        }

    }
}
