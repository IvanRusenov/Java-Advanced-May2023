package GenericsExercises.A08CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")) {

            String[] commandData = input.split("\\s+");

            String command = commandData[0];

            switch (command) {
                case "Add":
                    list.addElement(commandData[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(commandData[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(commandData[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(commandData[1]), Integer.parseInt(commandData[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(commandData[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;

            }

            input = scan.nextLine();
        }


    }
}
