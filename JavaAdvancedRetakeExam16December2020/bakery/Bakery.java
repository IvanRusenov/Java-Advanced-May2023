package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {

    public List<Employee> employees;
    public String name;
    public int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee){

        if (employees.size()<capacity){

            employees.add(employee);

        }
    }

    public boolean remove(String name){
        return employees.removeIf(employee -> employee.name.equals(name));
    }

    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name){
        return employees.stream().filter(e-> e.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:", name));
        employees.stream().forEach(e-> sb.append(System.lineSeparator()).append(e.toString()));
        return sb.toString();

    }
}
