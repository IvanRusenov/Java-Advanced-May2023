package DefiningClassesExercises.A07Google;

public class Company {

    String companyName;
    String companyDepartment;
    double salary;

    public Company(String companyName, String companyDepartment, double salary) {
        this.companyName = companyName;
        this.companyDepartment = companyDepartment;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
