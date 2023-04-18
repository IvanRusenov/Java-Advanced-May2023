package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A03DecimalToBinary {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //10 %2 = 0
        //5  %2 = 1
        //2  %2 = 0
        //1  %2 = 1

        //1 0 1 0

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int n = Integer.parseInt(scan.nextLine());

        if (n != 0){

            while (n > 0) {

                numbers.push(n % 2);
                n /= 2;

            }

            while (!numbers.isEmpty()) {

                System.out.printf("%d", numbers.pop());

            }

        } else {

            System.out.println(0);

        }

    }
}
