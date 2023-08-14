package JavaAdvancedExam18February2023.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {

        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }

        return false;
    }

    public boolean removeChild(String firstName){

        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)){
                registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount(){
        return registry.size();
    }

    public Child getChild(String firstName){
        return registry.stream().filter(child -> child.getFirstName().equals(firstName)).findFirst().get();

    }

    public String registryReport(){

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", name));
        sb.append(System.lineSeparator());
        registry.stream()
                .sorted(Comparator.comparing(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName))
                .forEach(child -> sb.append("--")
                        .append(System.lineSeparator())
                        .append(child.toString())
                        .append(System.lineSeparator()));

        return sb.toString();
    }
}
