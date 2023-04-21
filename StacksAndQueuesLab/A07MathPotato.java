package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A07MathPotato {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> kids = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<String> removedKids = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());

        int index = 0;
        int cycle = 0;

        while (kids.size() > 1) {

            cycle++;

            index = (index + n - 1) % kids.size();

            boolean isPrimeIndex = true;

            if (cycle < 2){

                isPrimeIndex = false;

            }else {

                for (int i = 2; i < cycle; i++) {

                    if (cycle % i == 0){

                        isPrimeIndex = false;
                        break;

                    }

                }
            }

            if (isPrimeIndex){

                System.out.printf("Prime %s\n", kids.get(index));

            }else {

                System.out.printf("Removed %s\n", kids.get(index));
                kids.remove(index);

            }

        }

        System.out.println("Last is " + kids.get(0));
    }
}

// В документа е зададен един изход а в джъдж друг при еднакви входни данни
