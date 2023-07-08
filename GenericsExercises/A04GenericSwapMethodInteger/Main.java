package GenericsExercises.A04GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Box<Integer> box = new Box<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            int input = Integer.parseInt(scan.nextLine());
            box.getList().add(input);

        }

        String[] indices = scan.nextLine().split("\\s+");

        int index1 = Integer.parseInt(indices[0]);
        int index2 = Integer.parseInt(indices[1]);

        box.swap(index1,index2);

        box.getList().forEach(e -> System.out.printf("%s: %s\n", e.getClass().getName(), e));



    }
}
