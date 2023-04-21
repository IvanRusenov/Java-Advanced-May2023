package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class A08BrowserHistoryUpgrade {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Deque<String> urls = new ArrayDeque<>();
        Deque<String> forwardUrls = new ArrayDeque<>();

        String input = scan.nextLine();

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (urls.size() < 2) {

                    System.out.println("no previous URLs");

                } else {

                    forwardUrls.addFirst(urls.peek());
                    urls.pop();
                    System.out.println(urls.peek());

                }

            } else if (input.equals("forward")) {

                if (forwardUrls.isEmpty()) {

                    System.out.println("no next URLs");

                } else {

                    urls.push(forwardUrls.peek());
                    System.out.println(forwardUrls.pop());

                }

            } else {

                urls.push(input);
                System.out.println(input);
                forwardUrls.clear();

            }

            input = scan.nextLine();

        }
    }
}