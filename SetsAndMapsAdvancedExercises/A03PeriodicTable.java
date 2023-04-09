package Advanced.SetsAndMapsAdvancedExercises;

import java.util.*;

public class A03PeriodicTable {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0){

            String input = scan.nextLine();

            String [] data = input.split("\\s+");

            for (String el : data) {
                elements.add(el);
            }

            //elements.addAll(Arrays.asList(data));


        }

        elements.forEach(e-> System.out.printf("%s ", e));

    }
}
