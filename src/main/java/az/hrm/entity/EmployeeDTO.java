package az.hrm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeDTO {

    @NotBlank
    @Positive
    private String id;

    @NotBlank(message = "{employeedto.firstName.notnull}")
    @Size(min = 3, max = 15, message = "{employeedto.firstName.size}")
    private String firstName;

    @NotBlank(message = "{employeedto.lastName.notnull}")
    @Size(min = 3, max = 25, message = "{employeedto.lastName.size}")
    private String lastName;

    @NotBlank(message = "{employeedto.salary.notnull}")
    @Positive(message = "{employeedto.salary.positive}")
    @Min(value = 190, message = "{employeedto.salary.min}")
    private String salary;

    @NotBlank(message = "{employeedto.hireDate.notnull}")
    private String hireDate;

    @NotBlank(message = "{employeedto.jobID.notnull}")
    private String jobID;

    @NotBlank(message = "{employeedto.email.notnull}")
    private String email;

    @NotBlank(message = "{employeedto.phoneNumber.notnull}")
    private String phoneNumber;


//    public EmployeeDTO() {
//    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getSalary() {
//        return salary;
//    }
//
//    public void setSalary(String salary) {
//        this.salary = salary;
//    }
//
//    public String getHireDate() {
//        return hireDate;
//    }
//
//    public void setHireDate(String hireDate) {
//        this.hireDate = hireDate;
//    }
//
//    public String getJobID() {
//        return jobID;
//    }
//
//    public void setJobID(String jobID) {
//        this.jobID = jobID;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeeDTO {" +
//                "id='" + id + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", salary='" + salary + '\'' +
//                ", hireDate='" + hireDate + '\'' +
//                ", jobID='" + jobID + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
//    }
}
