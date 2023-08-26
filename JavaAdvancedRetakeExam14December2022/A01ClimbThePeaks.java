package JavaAdvancedRetakeExam14December2022;

import java.util.*;

public class A01ClimbThePeaks {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> foodSupplies = new ArrayDeque<>();//stack
        ArrayDeque<Integer> dailyStamina = new ArrayDeque<>();//queue

        Arrays.stream(scan.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(foodSupplies::push);
        Arrays.stream(scan.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(dailyStamina::offer);

        Map<String, Integer> peaks = new LinkedHashMap<>();
        peaks.put("Vihren", 80);
        peaks.put("Kutelo", 90);
        peaks.put("Banski Suhodol", 100);
        peaks.put("Polezhan", 60);
        peaks.put("Kamenitza", 70);

        List<String> conqueredPeaks = new ArrayList<>();
        int days = 0;
        boolean isAllConquered = false;


        while (!foodSupplies.isEmpty() && !dailyStamina.isEmpty()) {

            days++;
            int food = foodSupplies.pop();
            int stamina = dailyStamina.poll();

            int sum = food + stamina;

            for (Map.Entry<String, Integer> entry : peaks.entrySet()) {

                if (sum >= entry.getValue()) {

                    conqueredPeaks.add(entry.getKey());
                    peaks.remove(entry.getKey());

                }

                break;

            }

            if (conqueredPeaks.size() >= 5 && days <= 7) {

                isAllConquered = true;
                break;

            }

        }

        if (isAllConquered) {

            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");

        } else {

            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");

        }

        if (conqueredPeaks.size() > 0) {

            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach(System.out::println);

        }

    }
}
