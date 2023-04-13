package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A07HandsOfCards {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> playerCardsMap = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (!input.equals("JOKER")) {

            String[] data = input.split(": ");
            String name = data[0];
            String cards = data[1];
            String regex = "(?<power>[\\d]+|[JQKA])(?<type>[CHSD])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cards);
            playerCardsMap.putIfAbsent(name, new ArrayList<>());

            while (matcher.find()) {

                String card = matcher.group();

                if (!playerCardsMap.get(name).contains(card)) {

                    playerCardsMap.get(name).add(card);
                }

            }

            input = scan.nextLine();
        }

        Map<String, Integer> playerPointsMap = new LinkedHashMap<>();

        playerCardsMap.forEach((k, v) -> {

            int value = 0;

            for (String s : v) {

                Pattern pattern = Pattern.compile("(?<power>[\\d]+|[JQKA])(?<type>[CHSD])");
                Matcher matcher = pattern.matcher(s);

                while (matcher.find()) {

                    String power = matcher.group("power");
                    String type = matcher.group("type");
                    value += calculateValue(power,type);

                }

            }

            playerPointsMap.putIfAbsent(k, 0);
            playerPointsMap.put(k, playerPointsMap.get(k) + value);

        });

        playerPointsMap.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));

    }

    private static int calculateValue(String text1, String text2) {
        int power = 0;
        int type = 0;

        if (text1.equals("J")
                || text1.equals("Q")
                || text1.equals("K")
                || text1.equals("A")) {

            switch (text1) {
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
            }

        } else {

            power = Integer.parseInt(text1);

        }

        switch (text2) {

            case "S":
                type = 4;
                break;
            case "H":
                type = 3;
                break;
            case "D":
                type = 2;
                break;
            case "C":
                type = 1;
                break;
        }

        return power * type;

    }

}
