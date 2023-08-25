package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }


    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {

        if (students.contains(student)) {//!!!
            return "Student is already in the university";
        }

        if (students.size() < capacity) {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }

        return "No seats in the university";


    }

    public String dismissStudent(Student student) {


        if (students.remove(student)) {

            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.firstName.equals(firstName) && student.lastName.equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", student.getFirstName()
                            , student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator());

        }
        return sb.toString();
    }
}
