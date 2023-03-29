package Advanced.SetsAndMapsAdvancedExercises;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A09PopulationCounter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Long>> countryCitiPopulationMap = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("report")) {

            String[] data = input.split("\\|");

            String country = data[1];
            String city = data[0];
            long population = Integer.parseInt(data[2]);

            countryCitiPopulationMap.putIfAbsent(country, new LinkedHashMap<>());
            countryCitiPopulationMap.get(country).putIfAbsent(city, 0L);
            countryCitiPopulationMap.get(country).put(city, countryCitiPopulationMap.get(country).get(city) + population);

            input = scan.nextLine();
        }

        countryCitiPopulationMap.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().values().stream().mapToLong(i -> i).sum() * -1))
                .forEach(entry -> {

                    long totalPopulation = entry.getValue().values().stream().mapToLong(i -> i).sum();

                    System.out.printf("%s (total population: %d)\n", entry.getKey(), totalPopulation);

                    entry.getValue().entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(entry1 -> {
                                System.out.printf("=>%s: %d\n", entry1.getKey(), entry1.getValue());

                            });

                });

    }
}
