package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A08UserLogs {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> userIpCountMap = new TreeMap<>();

        String input = scan.nextLine();
        String regex = "IP=(?<ip>(?<==)[\\d+A-Za-z:.]+) message='(?<message>(.*))' user=(?<user>\\w+)";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("end")){

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){

                String ip = matcher.group("ip");
                String user = matcher.group("user");

                userIpCountMap.putIfAbsent(user, new LinkedHashMap<>());
                userIpCountMap.get(user).putIfAbsent(ip,0);
                userIpCountMap.get(user).put(ip,userIpCountMap.get(user).get(ip) +1);

            }

            input =scan.nextLine();
        }

        userIpCountMap.forEach((k, v) -> {

            System.out.printf("%s:\n", k);
            List<String> output = new ArrayList<>();

            v.forEach((k1,v1) -> {

               output.add(String.format("%s => %d", k1, v1));

            });

            System.out.printf("%s.\n", String.join(", ", output));

        });

    }
}
