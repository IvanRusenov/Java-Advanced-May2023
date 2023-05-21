package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06StringMatrixRotation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(command);
        int degrees = 0;

        if (matcher.find()) {

            degrees = Integer.parseInt(matcher.group());

        }

        String input = scan.nextLine();
        List<char[]> list = new ArrayList<>();

        while (!input.equals("END")) {

            list.add(input.toCharArray());

            input = scan.nextLine();

        }


        if (degrees % 360 == 0) {

            print0(list);

        } else if (degrees % 360 == 90) {

            print90(list);

        } else if (degrees % 360 == 180) {

            print180(list);

        } else if (degrees % 360 == 270) {

            print270(list);

        }

    }

    private static int getMaxLength(List<char[]> list) {

        int maxLength = Integer.MIN_VALUE;

        for (char[] chars : list) {

            if (chars.length > maxLength) {

                maxLength = chars.length;

            }
        }

        return maxLength;

    }
    private static void print0(List<char[]> list) {

        for (char[] chars : list) {

            for (char aChar : chars) {

                System.out.printf("%c", aChar);

            }

            System.out.println();

        }

    }

    private static void print90(List<char[]> list) {

        int maxLength = getMaxLength(list);

        for (int row = 0; row < maxLength; row++) {

            for (int col = list.size() - 1; col >= 0; col--) {

                if (col < list.size() && row < list.get(col).length) {

                    System.out.printf("%c", list.get(col)[row]);

                } else {

                    System.out.print(" ");

                }

            }

            System.out.println();

        }

    }
    private static void print180(List<char[]> list) {

        int maxLength = getMaxLength(list);

        for (int row = list.size() - 1; row >= 0; row--) {

            for (int col = maxLength - 1; col >= 0; col--) {

                if (col > list.get(row).length - 1) {

                    System.out.print(" ");

                } else {

                    System.out.printf("%c", list.get(row)[col]);

                }

            }

            System.out.println();

        }

    }
    private static void print270(List<char[]> list) {

        int maxLength = getMaxLength(list);

        for (int row = maxLength - 1; row >= 0; row--) {

            for (char[] chars : list) {

                if (row >= chars.length) {

                    System.out.print(" ");

                } else {

                    System.out.printf("%c", chars[row]);
                }
            }

            System.out.println();

        }

    }
}
