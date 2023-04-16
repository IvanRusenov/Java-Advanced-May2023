package StacksAndQueuesLab;

import java.util.*;

public class A01BrowserHistory {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String input = scan.nextLine();
        String currentPlace = null;

        while (!input.equals("Home")){

            if (input.equals("back")){

                if (history.isEmpty()){

                    System.out.println("no previous URLs");

                } else {

                    currentPlace = history.pop();
                    System.out.println(currentPlace);

                }

            }else {

                if (currentPlace != null){

                    history.push(currentPlace);
                    currentPlace = input;

                }else {

                    currentPlace = input;

                }

                System.out.println(currentPlace);

            }

            input = scan.nextLine();
        }
    }
}
