package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;

public class A10LogsAggregator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, Integer>> userIpDurationMap = new TreeMap<>();

        while (n-- > 0) {

            String[] input = scan.nextLine().split("\\s+");

            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            userIpDurationMap.putIfAbsent(user, new TreeMap<>());
            userIpDurationMap.get(user).putIfAbsent(ip, 0);
            userIpDurationMap.get(user).put(ip, userIpDurationMap.get(user).get(ip) + duration);

        }

        userIpDurationMap.forEach((k, v) -> {

            List<String> ips = new ArrayList<>();

            v.forEach((k1, v1) -> {

                ips.add(k1);

            });

            int sum = v.values().stream().mapToInt(i -> i).sum();
            System.out.printf("%s: %d [%s]\n", k, sum, String.join(", ", ips));

        });

    }
}
