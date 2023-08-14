package JavaAdvancedExam18February2023;

import java.util.*;
import java.util.stream.Collectors;

public class A01ApocalypsePreparation {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> textiles = new ArrayDeque<>();//queue
        ArrayDeque<Integer> medicaments = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(textiles::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(medicaments::push);

        Map<String, Integer> items = new HashMap<>();

        while (!medicaments.isEmpty() && !textiles.isEmpty()) {

            int textile = textiles.poll();
            int medicament = medicaments.pop();
            int sum = textile + medicament;

            switch (sum) {

                case 30:
                    items.putIfAbsent("Patch", 0);
                    items.put("Patch", items.get("Patch") + 1);
                    break;

                case 40:
                    items.putIfAbsent("Bandage", 0);
                    items.put("Bandage", items.get("Bandage") + 1);
                    break;

                case 100:
                    items.putIfAbsent("MedKit", 0);
                    items.put("MedKit", items.get("MedKit") + 1);
                    break;

                default:

                    if (sum > 100) {

                        items.putIfAbsent("MedKit", 0);
                        items.put("MedKit", items.get("MedKit") + 1);
                        int difference = sum - 100;
                        medicaments.push(medicaments.pop() + difference);

                    } else {

                        medicaments.push(medicament + 10);

                    }

                    break;

            }

        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {

            System.out.println("Textiles and medicaments are both empty.");

        } else if (medicaments.isEmpty()) {

            System.out.println("Medicaments are empty.");

        } else {

            System.out.println("Textiles are empty.");

        }


        if (!items.isEmpty()) {

            items.entrySet().stream().sorted((f, s) -> {

                int result = s.getValue().compareTo(f.getValue());
                if (result == 0) {
                    return f.getKey().compareTo(s.getKey());
                }
                return result;

            }).forEach(e -> System.out.printf("%s - %d\n", e.getKey(), e.getValue()));

        }

        if (!medicaments.isEmpty()) {

            System.out.printf("Medicaments left: %s\n", medicaments.stream().map(e -> e + "")
                    .collect(Collectors.joining(", ")));

        }

        if (!textiles.isEmpty()) {

            System.out.printf("Textiles left: %s\n", textiles.stream().map(e -> e + "")
                    .collect(Collectors.joining(", ")));

        }

    }
}
