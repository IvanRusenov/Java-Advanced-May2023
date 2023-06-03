package SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class A02SoftUniParty {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String invitedGuests = scan.nextLine();

        while (!invitedGuests.equals("PARTY")) {

            guests.add(invitedGuests);
            invitedGuests = scan.nextLine();

        }

        String guestsPresent = scan.nextLine();

        while (!guestsPresent.equals("END")) {

            guests.remove(guestsPresent);

            guestsPresent = scan.nextLine();
        }

        System.out.println(guests.size());
        guests.forEach(System.out::println);
    }
}
