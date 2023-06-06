package SetsAndMapsAdvancedLab;

import java.util.*;

public class A05AverageStudentsGrades {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> studentGradeMap = new TreeMap<>();

        while (numberOfStudents-- > 0) {

            String[] studentData = scan.nextLine().split("\\s+");
            String name = studentData[0];
            double grade = Double.parseDouble(studentData[1]);

            studentGradeMap.putIfAbsent(name, new ArrayList<>());
            studentGradeMap.get(name).add(grade);

        }

        studentGradeMap.forEach((k, v) -> {

            System.out.printf("%s -> ", k);

            for (Double grade : v) {

                System.out.printf("%.2f ", grade);

            }

            System.out.printf("(avg: %.2f)\n"
                    , average(v));

        });

    }
    private static double average(List<Double> grades){
        double sum = 0.0;

        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}
