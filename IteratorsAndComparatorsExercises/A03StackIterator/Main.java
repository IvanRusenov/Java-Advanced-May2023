package IteratorsAndComparatorsExercises.A03StackIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String input = scan.nextLine();

        while (!input.equals("END")){

            if (input.startsWith("Push")){

                String[] command = input.substring(5).trim().split(",\\s+");
                for (String s : command) {
                    stack.Push(Integer.parseInt(s));
                }
                
            } else if (input.startsWith("Pop")) {

                try {
                    stack.Pop();
                } catch (Exception e) {
                    System.out.println("No elements");;
                }

            }


            input =  scan.nextLine();
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
