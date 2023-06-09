package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A08AcademyGraduation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Double> studentAvgGradeMap = new TreeMap<>();

        while (n-- > 0) {

            String student = scan.nextLine();
            double avgGrade = getAvgGrade(scan);
            studentAvgGradeMap.put(student, avgGrade);

        }

        DecimalFormat df = new DecimalFormat("#.#####################");
        studentAvgGradeMap.forEach((k, v) -> {
            System.out.printf("%s is graduated with %s\n", k, df.format(v));
        });

    }

    private static double getAvgGrade(Scanner scan) {

        double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        double sum = 0;

        for (double grade : grades) {

            sum += grade;

        }

        return sum / grades.length;

    }
}
