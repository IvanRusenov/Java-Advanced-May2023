package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A07SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int opsNumber = Integer.parseInt(scan.nextLine());
        String text = "";
        ArrayDeque<String> stack = new ArrayDeque<>();


        while (opsNumber-- > 0){

            String[] commands = scan.nextLine().split("\\s+");
            String command = commands[0];


            switch (command){

                case "1":
                    stack.push(text);
                    String stringToAppend = commands[1];
                    StringBuilder sb = new StringBuilder(text);
                    text = sb.append(stringToAppend).toString();
                    //•	"1 {string}" - appends [string] to the end of the text.
                    break;
                case "2":
                    stack.push(text);
                    int count = Integer.parseInt(commands[1]);
                    sb = new StringBuilder(text);
                    text = sb.delete(sb.length()-count,sb.length()).toString();

                    //•	"2 {count}" - erases the last [count] elements from the text.
                    break;

                case "3":
                    int index = Integer.parseInt(commands[1]) - 1;
                    System.out.println(text.charAt(index));
                    //•	"3 {index}" - returns the element at position [index] from the text.
                    break;
                case "4":
                    text = stack.pop();
                    //•	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.
                    break;

            }
        }

    }
}
