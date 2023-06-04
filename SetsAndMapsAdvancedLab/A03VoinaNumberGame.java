package SetsAndMapsAdvancedLab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class A03VoinaNumberGame {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            firstPlayer.add(scan.nextInt());
        }

        for (int i = 0; i < 20; i++) {
            secondPlayer.add(scan.nextInt());
        }

        int count = 0;

        while (firstPlayer.size() > 0 && secondPlayer.size() > 0 && count < 50) {

            count++;

            int fNum = firstPlayer.iterator().next();
            int sNum = secondPlayer.iterator().next();

            removeNum(firstPlayer, fNum);
            removeNum(secondPlayer, sNum);

            if (fNum > sNum) {

                addToPlayersNums(firstPlayer, fNum);
                addToPlayersNums(firstPlayer, sNum);

            } else if (fNum < sNum) {

                addToPlayersNums(secondPlayer, fNum);
                addToPlayersNums(secondPlayer, sNum);

            }

        }

        if (firstPlayer.size() <= 0) {

            System.out.println("Second player win!");

        } else if (secondPlayer.size() <= 0) {

            System.out.println("First player win!");

        } else if (firstPlayer.size() == secondPlayer.size()){

            System.out.println("Draw!");

        } else if (firstPlayer.size() < secondPlayer.size()) {

            System.out.println("Second player win!");

        } else if (secondPlayer.size() < firstPlayer.size()) {

            System.out.println("First player win!");

        }

    }
    private static void removeNum(Set<Integer> player, int num) {

        player.remove(num);

    }

    private static void addToPlayersNums(Set<Integer> player, int num) {

        player.add(num);

    }

}
