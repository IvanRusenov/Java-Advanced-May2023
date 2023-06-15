package DefiningClassesExercises.A02CompanyRoster;

public class Employee {

    //Define a class Employee that holds the following information:
    // name, salary, position, department, email, and age.
    // The name, salary, position, and department are mandatory
    // , while the rest are optional.
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;//opt
    private int age;//opt

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %s %d"
                , this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
