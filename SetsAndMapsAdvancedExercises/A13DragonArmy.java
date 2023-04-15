package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;

public class A13DragonArmy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int[] stats = new int[3];

            for (int j = 2; j < 5; j++) {
                if (input[j].equals("null")) {
                    stats[j - 2] = getDefaultStat(j - 2);
                } else {
                    stats[j - 2] = Integer.parseInt(input[j]);
                }
            }

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }

            dragons.get(type).put(name, stats);
        }

        for (Map.Entry<String, Map<String, int[]>> entry : dragons.entrySet()) {
            String type = entry.getKey();
            Map<String, int[]> dragonsOfType = entry.getValue();

            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;

            for (int[] stats : dragonsOfType.values()) {
                totalDamage += stats[0];
                totalHealth += stats[1];
                totalArmor += stats[2];
            }

            int count = dragonsOfType.size();
            double avgDamage = totalDamage / count;
            double avgHealth = totalHealth / count;
            double avgArmor = totalArmor / count;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, int[]> dragonEntry : dragonsOfType.entrySet()) {
                String name = dragonEntry.getKey();
                int[] stats = dragonEntry.getValue();

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name, stats[0], stats[1], stats[2]);
            }
        }
    }

    private static int getDefaultStat(int index) {
        int[] defaults = {45, 250, 10};
        return defaults[index];
    }
}


