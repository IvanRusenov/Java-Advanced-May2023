package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

     private List<Employee> employees;
     private String name;
     private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (employees.size()<capacity){
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        return  employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:",name));
        employees.forEach(e-> sb.append(System.lineSeparator()).append(e.toString()));
        return sb.toString();

    }
}
