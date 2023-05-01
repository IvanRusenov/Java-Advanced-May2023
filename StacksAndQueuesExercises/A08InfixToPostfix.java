package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A08InfixToPostfix {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {

            String str = input[i];

            if (isDigit(str) || isVariable(str)) {

                queue.offer(str);

            } else {

                switch (str) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "^":
                        priority(operatorsStack, str, queue);
                        break;
                    case "(":
                        operatorsStack.push(str);
                        break;
                    case ")":
                        while (!operatorsStack.peek().equals("(")) {

                            queue.offer(operatorsStack.pop());

                        }

                        operatorsStack.pop();
                        break;
                }
            }
        }

        while (!operatorsStack.isEmpty()) {

            queue.offer(operatorsStack.pop());

        }

        StringBuilder output = new StringBuilder();

        while (!queue.isEmpty()) {

            output.append(queue.poll()).append(" ");

        }

        System.out.println(output.toString().trim());

    }

    private static boolean isDigit(String str) {

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (!Character.isDigit(ch)) {

                return false;
            }

        }

        return true;
    }

    private static boolean isVariable(String str) {

        return str.matches("[a-zA-Z]+");

    }

    private static int value(String str) {

        if (str != null) {

            if (str.equals("^")) {

                return 3;

            } else if (str.equals("/") || str.equals("*")) {

                return 2;

            } else if (str.equals("-") || str.equals("+")) {

                return 1;
            }

        }

        return 0;
    }

    private static void priority(ArrayDeque<String> stack, String str, ArrayDeque<String> queue) {

        while (!stack.isEmpty() && !stack.peek().equals("(") && value(stack.peek()) >= value(str)) {

            queue.offer(stack.pop());

        }

        stack.push(str);
    }
}

