package JavaAdvancedExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A01OSPlaning {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> tasks = new ArrayDeque<>();//stack
        Deque<Integer> threads = new ArrayDeque<>();//queue

        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(tasks::push);
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(threads::offer);

        int taskToKill = Integer.parseInt(scan.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {

            int task = tasks.peek();
            int thread = threads.peek();

            if (task == taskToKill) {

                System.out.printf("Thread with value %d killed task %d\n", thread, task);
                System.out.println(threads.stream().map(e -> e + "").collect(Collectors.joining(" ")));
                break;

            }

            if (thread < task) {

                threads.poll();

            } else {
                tasks.pop();
                threads.poll();
            }

        }
    }
}

