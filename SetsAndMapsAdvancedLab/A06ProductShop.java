package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A06ProductShop {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Map<String,Double>> shopProductPriceMap = new TreeMap<>();

        while (!input.equals("Revision")){

            String[]data = input.split(",\\s+");

            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);


            shopProductPriceMap.putIfAbsent(shop,new LinkedHashMap<>());
            shopProductPriceMap.get(shop).put(product,price);
            //check if product already is in a shop
            input = scan.nextLine();

        }

        shopProductPriceMap.forEach((k,v)->{
            System.out.printf("%s->\n", k);

            v.forEach((key, value) -> {
                System.out.printf("Product: %s, Price: %.1f\n", key, value);
            });


        });
    }
}
