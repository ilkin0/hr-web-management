package az.hrm.form;

import javax.validation.constraints.*;

public class EmployeeForm {
    @NotBlank
    @Positive
    private String id;

    @NotBlank(message = "{employeeForm.firstName.notnull}")
    @Size(min = 3 , max = 15, message = "{employeeForm.firstName.size}")
    private String firstName;

    @NotBlank(message = "{employeeForm.lastName.notnull}")
    @Size(min = 3 , max = 25, message = "{employeeForm.lastName.size}")
    private String lastName;

    @NotBlank(message = "{employeeForm.salary.notnull}")
    @Positive(message = "{employeeForm.salary.positive}")
    @Min(value = 190, message = "{employeeForm.salary.min}")
    private String salary;

    @NotBlank(message = "{employeeForm.hireDate.notnull}")
//    @PastOrPresent(message = "{employeeForm.hireDate.pastorPresent}")
    private String hireDate;

    @NotBlank(message = "{employeeForm.jobID.notnull}")
    private String jobID;

    @NotBlank(message = "{employeeForm.email.notnull}")
    private String email;

    @NotBlank(message = "{employeeForm.phoneNumber.notnull}")
    private String phoneNumber;


    public EmployeeForm() {
    }

    public EmployeeForm(String id, String firstName, String lastName, String salary, String hireDate, String jobID, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.hireDate = hireDate;
        this.jobID = jobID;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "EmployeeForm{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary='" + salary + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", jobID='" + jobID + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
