package JAVA_ADVANCED_REAL_EXAM_17_06_2023;

import java.util.*;
import java.util.stream.Collectors;

public class A01TempleOfDoom {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tools = new ArrayDeque<>();//queue
        ArrayDeque<Integer> substances = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(tools::offer);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(substances::push);

        List<Integer> challenges = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!tools.isEmpty() && !substances.isEmpty() && !challenges.isEmpty()) {

            int tool = tools.poll();
            int substance = substances.pop();
            int result = tool * substance;

            if (challenges.contains(result)) {

                challenges.remove((Integer) result);

            } else {

                tools.offer(tool + 1);

                if (substance - 1 > 0) {

                    substances.push(substance - 1);

                }

            }

        }

        if (!challenges.isEmpty()) {

            System.out.println("Harry is lost in the temple. Oblivion awaits him.");

        } else {

            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");

        }

        if (!tools.isEmpty()) {

            System.out.printf("Tools: %s\n", tools.stream().map(e -> e + "").collect(Collectors.joining(", ")));

        }

        if (!substances.isEmpty()) {

            System.out.printf("Substances: %s\n", substances.stream().map(e -> e + "").collect(Collectors.joining(", ")));

        }

        if (!challenges.isEmpty()) {

            System.out.printf("Challenges: %s\n", challenges.stream().map(e -> e + "").collect(Collectors.joining(", ")));

        }

    }
}
