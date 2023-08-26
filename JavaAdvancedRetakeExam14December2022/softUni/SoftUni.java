package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {

        if (data.size() < capacity) {

            for (Student student1 : data) {

                if (student1.getFirstName().equals(student.getFirstName())
                        && student1.getLastName().equals(student.getLastName())) {
                    return "Student is already in the hall.";
                }

            }

            data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());

        }

        return "The hall is full.";

    }

    public String remove(Student student){

        for (Student student1 : data) {
            if (student.getFirstName().equals(student1.getFirstName())
                    && student.getLastName().equals(student1.getLastName())){
                data.remove(student);
                return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
            }
        }

        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : data) {
           if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
               return student;
           }
        }
        return null;
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hall size: %d", data.size()));

        for (Student student : data) {
            sb.append(System.lineSeparator())
            .append(student.toString());
        }

        return sb.toString();

    }
}
