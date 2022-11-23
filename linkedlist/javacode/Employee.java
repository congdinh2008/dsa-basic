import java.time.LocalDate;
public class Employee {
    private String ssn;
    private String fullName;
    private LocalDate hireDate;

    public Employee(String ssn, String fullName, LocalDate hireDate) {
        this.ssn = ssn;
        this.fullName = fullName;
        this.hireDate = hireDate;
    }

    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return fullName;
    }
    
}
