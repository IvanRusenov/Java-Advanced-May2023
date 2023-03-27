package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;

public class A13DragonArmy2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, int[]>> typeNameStatsMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {

            String[] data = scan.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            int[] stats = new int[3];
            stats[0] = data[2].equals("null") ? 45 : Integer.parseInt(data[2]);
            stats[1] = data[3].equals("null") ? 250 : Integer.parseInt(data[3]);
            stats[2] = data[4].equals("null") ? 10 : Integer.parseInt(data[4]);

            typeNameStatsMap.putIfAbsent(type, new TreeMap<>());
            typeNameStatsMap.get(type).put(name, stats);

        }

        for (Map.Entry<String, Map<String, int[]>> mapEntry : typeNameStatsMap.entrySet()) {

            int damageSum = 0;
            int helthSum = 0;
            int armorSum = 0;

            for (Map.Entry<String, int[]> entry : mapEntry.getValue().entrySet()) {

                damageSum += entry.getValue()[0];
                helthSum += entry.getValue()[1];
                armorSum += entry.getValue()[2];

            }

            double avgDamage = 1.0 * damageSum / mapEntry.getValue().size();
            double avgHealth = 1.0 * helthSum / mapEntry.getValue().size();
            double avgArmor = 1.0 * armorSum / mapEntry.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", mapEntry.getKey(), avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, int[]> entry : mapEntry.getValue().entrySet()) {

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", entry.getKey()
                        , entry.getValue()[0], entry.getValue()[1], entry.getValue()[2]);

            }

        }

    }

}
