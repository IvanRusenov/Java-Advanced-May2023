package GenericsExercises.A02GenericBoxOfInteger;

import GenericsExercises.A01GenericBox.Box;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            Integer info = Integer.parseInt(scan.nextLine());
            Box<Integer> box = new Box<>(info);
            System.out.println(box);
        }
    }
}
