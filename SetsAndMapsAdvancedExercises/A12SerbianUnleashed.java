package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A12SerbianUnleashed {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> venueSingerProfitMap = new LinkedHashMap<>();

        String input = scan.nextLine();

        Pattern pattern = Pattern.compile("(?<singer>[A-Za-z ]+)\\s@(?<venue>[A-Za-z ]+)\\s(?<price>[0-9]+)\\s(?<count>[0-9]+)");

        while (!input.equals("End")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                int total = price * count;

                venueSingerProfitMap.putIfAbsent(venue, new LinkedHashMap<>());

                if (!venueSingerProfitMap.get(venue).containsKey(singer)) {

                    venueSingerProfitMap.get(venue).put(singer, total);

                } else {

                    int newTotal = venueSingerProfitMap.get(venue).get(singer) + total;

                    venueSingerProfitMap.get(venue).put(singer, newTotal);

                }

            }

            input = scan.nextLine();
        }

        venueSingerProfitMap.forEach((k, v) -> {

            System.out.printf("%s\n", k);
            v.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> {

                System.out.printf("#  %s -> %d\n", entry.getKey(), entry.getValue());

            });
        });
    }
}
