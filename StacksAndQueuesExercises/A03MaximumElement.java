package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A03MaximumElement {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (n-- > 0) {

            int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int command = input[0];

            if (command == 1) {

                int num = input[1];
                stack.push(num);

            } else if (command == 2) {

                stack.pop();

            } else if (command == 3) {

                System.out.println(stack.stream().mapToInt(i -> i).max().getAsInt());

            }
        }
    }
}
