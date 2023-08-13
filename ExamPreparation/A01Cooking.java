package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class A01Cooking {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>(); // queue
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(); //stack

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        Map<Integer, String> valueProductMap = new HashMap<>();
        valueProductMap.put(25, "Bread");
        valueProductMap.put(50, "Cake");
        valueProductMap.put(75, "Pastry");
        valueProductMap.put(100, "Fruit Pie");

        Map<String, Integer> productValueMap = new TreeMap<>();

        productValueMap.put("Bread", 0);
        productValueMap.put("Cake", 0);
        productValueMap.put("Pastry", 0);
        productValueMap.put("Fruit Pie", 0);


        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if (valueProductMap.containsKey(sum)) {

                productValueMap.put(valueProductMap.get(sum), productValueMap.get(valueProductMap.get(sum)) + 1);


            } else {

                ingredients.push(ingredient + 3);

            }

        }

        if (!productValueMap.containsValue(0)) {

            System.out.println("Wohoo! You succeeded in cooking all the food!");

        } else {

            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");

        }

        if (liquids.isEmpty()) {

            System.out.println("Liquids left: none");

        } else {

            System.out.printf("Liquids left: %s\n", liquids.stream().map(e -> e + "").collect(Collectors.joining(", ")));

        }

        if (ingredients.isEmpty()) {

            System.out.println("Ingredients left: none");

        } else {

            System.out.printf("Ingredients left: %s\n", ingredients.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }


        productValueMap.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));

    }
}
