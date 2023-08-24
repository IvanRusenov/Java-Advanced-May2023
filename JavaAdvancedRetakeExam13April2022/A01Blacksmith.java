package JavaAdvancedRetakeExam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class A01Blacksmith {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> steel = new ArrayDeque<>();//queue
        ArrayDeque<Integer> carbon = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(steel::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(carbon::push);

        Map<String, Integer> swords = new TreeMap<>();

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int currentSteel = steel.poll();
            int currentCarbon = carbon.pop();

            int sum = currentSteel + currentCarbon;

            switch (sum) {
                case 70:
                    swords.putIfAbsent("Gladius", 0);
                    swords.put("Gladius", swords.get("Gladius") + 1);
                    break;
                case 80:
                    swords.putIfAbsent("Shamshir", 0);
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                    break;
                case 90:
                    swords.putIfAbsent("Katana", 0);
                    swords.put("Katana", swords.get("Katana") + 1);
                    break;
                case 110:
                    swords.putIfAbsent("Sabre", 0);
                    swords.put("Sabre", swords.get("Sabre") + 1);
                    break;
                default:
                    carbon.push(currentCarbon + 5);

            }

        }

        if (swords.size()>0){

            int totalNumberOfSwords = swords.values().stream().mapToInt(Integer::intValue).sum();
            System.out.printf("You have forged %d swords.\n", totalNumberOfSwords);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steel.isEmpty()){
            System.out.println("Steel left: none");
        }else {

            System.out.printf("Steel left: %s\n", steel.stream().map(e-> e+"")
                    .collect(Collectors.joining(", ")));
        }

        if (carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else {

            System.out.printf("Carbon left: %s\n", carbon.stream().map(e-> e+"")
                    .collect(Collectors.joining(", ")));
        }

        swords.forEach((k,v) -> System.out.printf("%s: %d\n", k, v));


    }
}
