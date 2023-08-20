package JavaAdvancedExam25June2022;

import java.util.*;

public class A01ItsChocolateTime {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Double> milkQuantity = new ArrayDeque<>();//queue
        ArrayDeque<Double> cacaoQuantity = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(milkQuantity::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(cacaoQuantity::push);

        Map<String, Integer> chocolates = new TreeMap<>();

        while (!cacaoQuantity.isEmpty() && !milkQuantity.isEmpty()){

            double milk = milkQuantity.poll();
            double cacao = cacaoQuantity.pop();
            double value = (cacao / (milk + cacao)) * 100;


            if (value == 30){
                chocolates.putIfAbsent("Milk Chocolate", 0);
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
            } else if (value == 50) {
                chocolates.putIfAbsent("Dark Chocolate", 0);
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
            }else if (value == 100) {
                chocolates.putIfAbsent("Baking Chocolate", 0);
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
            } else {
                milkQuantity.offer(milk + 10);
            }


        }

        if (chocolates.size() == 3){
           System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        if (chocolates.size() > 0 ){
            chocolates.forEach((k,v)-> System.out.printf(" # %s --> %d\n", k, v));
        }


    }
}
