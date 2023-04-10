package Advanced.SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A04CountSymbols {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Character, Integer> symbolCountMap = new TreeMap<>();

        for (char ch :input.toCharArray()) {

            symbolCountMap.putIfAbsent(ch,0);
            symbolCountMap.put(ch,symbolCountMap.get(ch) + 1);
        }

        symbolCountMap.forEach((k,v) -> System.out.printf("%c: %d time/s\n", k, v));
    }
}
