package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A04MatchingBrackets {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> startIndexes = new ArrayDeque<>();

        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '('){

                startIndexes.push(i);

            } else if (input.charAt(i) == ')') {

                System.out.println(input.substring(startIndexes.pop(),i +1));

            }
        }

    }
}
