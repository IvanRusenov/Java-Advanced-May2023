package JavaAdvancedExam23October2021;

import java.util.*;

public class A01AutumnCocktails {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();//queue
        ArrayDeque<Integer> freshness = new ArrayDeque<>(); //stack

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::offer);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {

            int ingredient = ingredients.peek();

            if (ingredient == 0) {

                ingredients.poll();
                continue;

            }

            int ingredientFreshness = freshness.peek();
            int totalFreshness = ingredient * ingredientFreshness;
            String cocktail = null;

            if (totalFreshness == 150) {

                cocktail = "Pear Sour";

            } else if (totalFreshness == 250) {

                cocktail = "The Harvest";

            } else if (totalFreshness == 300) {

                cocktail = "Apple Hinny";

            } else if (totalFreshness == 400) {

                cocktail = "High Fashion";

            }

            if (cocktail != null) {

                cocktails.putIfAbsent(cocktail, 0);
                cocktails.put(cocktail, cocktails.get(cocktail) + 1);

            } else {

                ingredients.offer((ingredient + 5));

            }

            freshness.pop();
            ingredients.poll();

        }

        if (cocktails.size() >= 4) {

            System.out.println("It's party time! The cocktails are ready!");

        } else {

            System.out.println("What a pity! You didn't manage to prepare all cocktails.");

        }

        if (!ingredients.isEmpty()) {

            int sum = ingredients.stream().mapToInt(i -> i).sum();

            if (sum > 0) {

                System.out.printf("Ingredients left: %d\n", sum);

            }

        }

        if (!cocktails.isEmpty()) {

            List<String> output = new ArrayList<>();
            cocktails.forEach((k, v) -> output.add(String.format(" # %s --> %d", k, v)));
            System.out.println(String.join(System.lineSeparator(), output));

        }

    }
}
