package JavaAdvancedExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class A01Bombs {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> bombs = new ArrayDeque<>();//queue
        ArrayDeque<Integer> casings = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(bombs::offer);
        Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(casings::push);

        Map<String, Integer> bombsMap = new TreeMap<>();

        bombsMap.put("Datura Bombs", 0);
        bombsMap.put("Cherry Bombs", 0);
        bombsMap.put("Smoke Decoy Bombs", 0);

        while (!bombs.isEmpty() && !casings.isEmpty()){

            int bomb = bombs.poll();
            int casing = casings.pop();
            int sum =  bomb + casing;

            if (sum == 40){

                bombsMap.put("Datura Bombs", bombsMap.get("Datura Bombs") + 1);

            } else if (sum == 60) {

                bombsMap.put("Cherry Bombs", bombsMap.get("Cherry Bombs") + 1);

            } else if (sum == 120) {

                bombsMap.put("Smoke Decoy Bombs", bombsMap.get("Smoke Decoy Bombs") + 1);

            }else {

                bombs.addFirst(bomb);
                casings.push(casing - 5);

            }

            if (bombsMap.values().stream().filter(v-> v >= 3).count() == 3 ){
                break;
            }


        }

        if (bombsMap.values().stream().anyMatch(v -> v < 3)){

            System.out.println("You don't have enough materials to fill the bomb pouch.");

        }else {

            System.out.println("Bene! You have successfully filled the bomb pouch!");

        }

        if (bombs.isEmpty()){

            System.out.println("Bomb Effects: empty");

        }else {

            System.out.printf("Bomb Effects: %s\n", bombs.stream().map(b -> b + "").collect(Collectors.joining(", ")));

        }

        if (casings.isEmpty()){

            System.out.println("Bomb Casings: empty");

        }else {

            System.out.printf("Bomb Casings: %s\n", casings.stream().map(c -> c + "").collect(Collectors.joining(", ")));

        }

        bombsMap.forEach((k,v)-> System.out.printf("%s: %d\n", k, v));

    }
}
