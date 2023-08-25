package JavaAdvancedRetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A01Bouquets {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tulips = new ArrayDeque<>();//stack
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();//queue

        Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(tulips::push);
        Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(daffodils::offer);

        int bouquets = 0;
        int storedSum = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {

            int tulip = tulips.pop();
            int daffodil = daffodils.peek();

            int sum = tulip + daffodil;

            if (sum == 15) {

                bouquets++;
                daffodils.poll();

            } else if (sum > 15) {

                tulips.push(tulip - 2);

            } else {

                storedSum += sum;
                daffodils.poll();

            }

        }

        bouquets += storedSum / 15;

        if (bouquets >= 5) {

            System.out.printf("You made it! You go to the competition with %d bouquets!\n", bouquets);

        } else {

            System.out.printf("You failed... You need more %d bouquets.\n", 5 - bouquets);

        }

    }
}
