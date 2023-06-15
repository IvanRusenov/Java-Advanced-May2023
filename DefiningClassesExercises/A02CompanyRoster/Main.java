package DefiningClassesExercises.A02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();
        Set<String> departments = new HashSet<>();
        while (n-- > 0){
            String[] input = scan.nextLine().split("\\s+");
            //name, salary, position, department, email, and age.
                String name = input[0];
                double salary = Double.parseDouble(input[1]);
                String position = input[2];
                String department = input[3];
                departments.add(department);

                Employee employee = new Employee(name, salary, position, department);

            if (input.length == 5){

                if (Character.isDigit(input[4].charAt(0))){
                    int age = Integer.parseInt(input[4]);
                    employee.setAge(age);

                }else {
                    String email = input[4];
                    employee.setEmail(email);
                }

            } else if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee.setAge(age);
                employee.setEmail(email);
            }

            employees.add(employee);

        }
        String highestSalaryDep = null;
        double highestAvgSalary = 0.0;

        while (!departments.isEmpty()){

            String department = departments.iterator().next();
            int count = 0;
            double sum = 0.0;
            for (Employee employee : employees) {
                if (employee.getDepartment().equals(department)){
                    sum += employee.getSalary();
                    count ++;
                }
            }
            double avgSalary = sum /count;
            if (highestAvgSalary < avgSalary){
                highestAvgSalary = avgSalary;
                highestSalaryDep = department;
            }
            departments.remove(department);

        }

        System.out.printf("Highest Average Salary: %s\n", highestSalaryDep);
        String finalHighestSalaryDep = highestSalaryDep;
        employees.stream()
                .filter(employee -> employee.getDepartment().equals(finalHighestSalaryDep))
                .sorted((f,s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));


    }
}
