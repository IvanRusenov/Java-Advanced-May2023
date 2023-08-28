package JavaAdvancedRetakeExam16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class A01Cooking {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();//queue
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredients::push);

        Map<String,Integer> food = new TreeMap<>();

        food.put("Bread", 0);
        food.put("Cake", 0);
        food.put("Pastry", 0);
        food.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()){

            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;

            if (sum == 25 ){
                food.put("Bread", food.get("Bread") + 1);
            } else if (sum == 50) {
                food.put("Cake", food.get("Cake") + 1);
            } else if (sum == 75) {
                food.put("Pastry", food.get("Pastry") + 1);
            } else if (sum == 100) {
                food.put("Fruit Pie", food.get("Fruit Pie") + 1);
            }else {
               ingredients.push(ingredient + 3);
            }



        }

        if (!food.containsValue(0)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            System.out.printf("Liquids left: %s\n", liquids.stream().map((l->l+"")).collect(Collectors.joining(", ")));
        }

        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            System.out.printf("Ingredients left: %s\n", ingredients.stream().map((l->l+"")).collect(Collectors.joining(", ")));
        }

       food.forEach((k,v) -> System.out.printf("%s: %d\n", k, v));







    }
}
