package JavaAdvancedRetakeExam12April2023;

import java.util.*;
import java.util.stream.Collectors;

public class A01RubberDuckDebuggers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        ArrayDeque<Integer> times = new ArrayDeque<>();//queue
        ArrayDeque<Integer> tasks = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(times::offer);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(tasks::push);


        Map<String, Integer> duckCountMap = new LinkedHashMap<>();
        duckCountMap.put("Darth Vader Ducky",0);
        duckCountMap.put("Thor Ducky",0);
        duckCountMap.put("Big Blue Rubber Ducky",0);
        duckCountMap.put("Small Yellow Rubber Ducky",0);

        while (!times.isEmpty() && !tasks.isEmpty()){

            int time =  times.poll();
            int task = tasks.pop();

            int result = time * task;

            if (result >= 0 && result <= 60){
                
                duckCountMap.put("Darth Vader Ducky", duckCountMap.get("Darth Vader Ducky") + 1);

            } else if (result >= 61 && result <= 120) {

                duckCountMap.put("Thor Ducky", duckCountMap.get("Thor Ducky") + 1);

            } else if (result >= 121 && result <= 180) {

                duckCountMap.put("Big Blue Rubber Ducky", duckCountMap.get("Big Blue Rubber Ducky") + 1);

            } else if (result >= 181 && result <= 240) {

                duckCountMap.put("Small Yellow Rubber Ducky", duckCountMap.get("Small Yellow Rubber Ducky") + 1);

            } else {

                times.offer(time);
                tasks.push(task - 2);

            }


        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        duckCountMap.forEach((k,v) -> System.out.printf("%s: %d\n", k, v));


    }
}
