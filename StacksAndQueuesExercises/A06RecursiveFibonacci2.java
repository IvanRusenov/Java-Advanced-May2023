package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A06RecursiveFibonacci2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        long n = Integer.parseInt(scan.nextLine());

        ArrayDeque<Long> queue = new ArrayDeque<>();

        queue.offer(1L);
        queue.offer(1L);

        if (n < 2) {

            System.out.println(1);

        } else {

            while (n-- > 0) {

                queue.offer(queue.poll() + queue.peek());

            }

            System.out.println(queue.peek());

        }

    }
}
