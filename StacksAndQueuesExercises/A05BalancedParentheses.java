package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class A05BalancedParentheses {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;

        for (int i = 0; i < input.length(); i++) {

            isBalanced = false;

            char ch = input.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {

                stack.push(ch);

            } else {

                if (!isMatch(ch, stack)) {
                    break;
                } else {
                    isBalanced = true;
                }

            }

        }

        if (stack.isEmpty() && isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean isMatch(char ch, Deque<Character> stack) {

        if (stack.isEmpty()) {

            return false;

        } else {

            switch (ch) {

                case ')':

                    return stack.pop() == '(';

                case ']':

                    return stack.pop() == '[';

                case '}':

                    return stack.pop() == '{';

            }
        }

        return false;

    }
}
