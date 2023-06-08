package SetsAndMapsAdvancedLab;

import java.util.*;

public class A07CitiesByContinentAndCountry {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, List<String>>> continentCountryCityMap = new LinkedHashMap<>();

        while (n-- > 0) {

            String[] data = scan.nextLine().split("\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            continentCountryCityMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentCountryCityMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentCountryCityMap.get(continent).get(country).add(city);

        }

        continentCountryCityMap.forEach((k, v) -> {

            System.out.printf("%s:\n", k);

            v.forEach((key, value) -> {
                System.out.printf("  %s -> %s\n", key, String.join(", ", value));
            });
        });
    }
}
