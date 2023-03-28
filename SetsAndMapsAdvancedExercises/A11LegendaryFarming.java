package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A11LegendaryFarming {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine().toLowerCase();

        Pattern pattern = Pattern.compile("(?<quantity>\\d+)\\s+(?<item>[a-zA-Z_-]+)");
        Map<String, Integer> items = new TreeMap<>();
        items.put("fragments", 0);
        items.put("shards", 0);
        items.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        boolean isLegendary = false;

        while (input.length() != 0) {

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                int quantity = Integer.parseInt(matcher.group("quantity"));
                String item = matcher.group("item");

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

            if (isLegendary) {
                break;
            }

            input = scan.nextLine().toLowerCase();
        }

        items.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {

            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());

        });

        junk.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));

    }

    private static boolean isMaterialOrJunk(String item) {

        return item.equalsIgnoreCase("shards") ||
                item.equalsIgnoreCase("fragments") ||
                item.equalsIgnoreCase("motes");

    }

    private static String whatLegendaryIsObtained(String item) {

        if (item.equalsIgnoreCase("shards")) {

            return "Shadowmourne";

        } else if (item.equalsIgnoreCase("fragments")) {

            return "Valanyr";

        } else if (item.equalsIgnoreCase("motes")) {

            return "Dragonwrath";

        }

        return "error";

    }

}
