package JavaAdvancedRetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> roses = new ArrayDeque<>();//queue
        ArrayDeque<Integer> lilies = new ArrayDeque<>();//stack

        Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(lilies::push);
        Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(roses::offer);


        int flowerWreaths = 0;
        int storedSum = 0;

        while (!roses.isEmpty() && !lilies.isEmpty()){
            int rose = roses.peek();
            int lilie = lilies.pop();

            int sum = rose+lilie;

            if (sum == 15){
                flowerWreaths++;
                roses.poll();
            } else if (sum>15) {
                lilies.push( lilie - 2);
            } else {
                storedSum+=sum;
                roses.poll();
            }


        }

        flowerWreaths += storedSum / 15;

        if (flowerWreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n", flowerWreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n", 5 - flowerWreaths);
        }


    }


}
