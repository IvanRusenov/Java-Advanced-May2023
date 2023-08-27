package JavaAdvancedRetakeExam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A01Meeting {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();//stack
        ArrayDeque<Integer> females = new ArrayDeque<>();//queue

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {

            int male = males.peek();

            if (male <= 0) {

                males.pop();
                continue;

            }

            int female = females.peek();

            if (female <= 0) {

                females.poll();
                continue;

            }

            if (male % 25 == 0) {

                males.pop();

                if (!males.isEmpty()) {

                    males.pop();
                    continue;

                } else {

                    break;

                }

            }

            if (female % 25 == 0) {

                females.poll();

                if (!females.isEmpty()) {

                    females.poll();
                    continue;

                } else {

                    break;

                }

            }

            males.pop();
            females.poll();

            if (male != female) {

                males.push(male - 2);

            } else {

                matches++;

            }
        }

        System.out.printf("Matches: %d\n", matches);

        if (males.isEmpty()) {

            System.out.println("Males left: none");

        } else {

            System.out.printf("Males left: %s\n", males.stream().map(m -> m + "")
                    .collect(Collectors.joining(", ")));

        }

        if (females.isEmpty()) {

            System.out.println("Females left: none");

        } else {

            System.out.printf("Females left: %s\n", females.stream().map(e -> e + "")
                    .collect(Collectors.joining(", ")));

        }

    }
}
