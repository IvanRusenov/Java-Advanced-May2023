package GenericsExercises.A06GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String input = scan.nextLine();
            box.getList().add(Double.parseDouble(input));

        }

        Double strToCompare = Double.parseDouble(scan.nextLine());
        int count = 0;

        for (Double s : box.getList()) {
            if (strToCompare.compareTo(s) < 0) {
                count++;
            }
        }
        System.out.println(count);

    }
}
