package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class A04CountRealNumbers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<Double,Integer> doublesCountMap = new LinkedHashMap<>();

        List<Double> doublesList = Arrays
                .stream(scan.nextLine().split("\\s+"))
               .map(Double::parseDouble)
               .collect(Collectors.toList());

        for (Double el : doublesList) {

            doublesCountMap.putIfAbsent(el, 0);
            doublesCountMap.put(el, doublesCountMap.get(el) +1);

        }

        doublesCountMap.forEach((k, v) -> System.out.printf("%.1f -> %d\n", k, v));

    }
}
