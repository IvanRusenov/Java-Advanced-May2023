package GenericsExercises.A05GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Box<String> box = new Box<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String input = scan.nextLine();
            box.getList().add(input);

        }

        String strToCompare = scan.nextLine();
        int count = 0;

        for (String s : box.getList()) {
            if (strToCompare.compareTo(s) < 0) {
                count++;
            }
        }
        System.out.println(count);

    }
}
