package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A06HotPotato {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> kids = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<String> removedKids = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());

        int index = 0;

        while (kids.size() > 1) {

            index = (index + n - 1) % kids.size();
            removedKids.offer(kids.get(index));
            kids.remove(index);

        }

        while (!removedKids.isEmpty()) {

            System.out.printf("Removed %s\n", removedKids.poll());

        }

        System.out.println("Last is " + kids.get(0));
    }
}
