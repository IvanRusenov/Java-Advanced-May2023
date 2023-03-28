package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;

public class A11LegendaryFarming2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Integer> items = new TreeMap<>();
        items.put("shards",0);
        items.put("motes",0);
        items.put("fragments",0);
        Map<String, Integer> junk = new TreeMap<>();
        boolean isLegendary = false;

        while (input.length() != 0 ) {

            String[] data = input.split("\\s+");

            for (int i = 0; i < data.length - 1; i += 2) {

                int quantity = Integer.parseInt(data[i]);
                String item = data[i+1].toLowerCase();

                if (isMaterialOrJunk(item)) {

                    items.put(item, items.get(item) + quantity);

                    if (items.get(item) >= 250) {

                        System.out.printf("%s obtained!\n", whatLegendaryIsObtained(item));

                        items.put(item, items.get(item) - 250);
                        isLegendary = true;
                        break;

                    }

                } else {

                    junk.putIfAbsent(item, 0);
                    junk.put(item, junk.get(item) + quantity);

                }

            }

            if (isLegendary){

                break;
            }

            input = scan.nextLine();
        }

        items.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        });

        junk.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));

    }

    private static boolean isMaterialOrJunk(String item) {

        return item.equalsIgnoreCase("Shards") ||
                item.equalsIgnoreCase("Fragments") ||
                item.equalsIgnoreCase("Motes");

    }

    private static String whatLegendaryIsObtained(String item) {

        if (item.equalsIgnoreCase("Shards")) {

            return "Shadowmourne";

        } else if (item.equalsIgnoreCase("Fragments")) {

            return "Valanyr";

        } else if (item.equalsIgnoreCase("Motes")) {

            return "Dragonwrath";

        }

        return "error";

    }

}