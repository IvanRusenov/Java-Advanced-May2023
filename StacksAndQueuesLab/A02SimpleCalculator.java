package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A02SimpleCalculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] input = scan.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i += 2) {

            if (i - 1 > 0 && input[i - 1].equals("-")) {

                numbers.push(-1 * Integer.parseInt(input[i]));

            } else {

                numbers.push(Integer.parseInt(input[i]));

            }

        }

        int result = 0;

        while (!numbers.isEmpty()) {

            result += numbers.pop();

        }

        System.out.println(result);

    }
}
