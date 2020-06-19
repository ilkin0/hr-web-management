package az.hrm.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

    private long id = 0L;
    private String firstName = "";
    private String lastName = "";
    private BigDecimal salary;
    private Date hireDate;
    private String jobID;
    private String email;
    private String phoneNumber;

//    public Employee() {
//        this.salary = BigDecimal.ZERO;
//        this.jobID = "";
//        this.email = "";
//        this.phoneNumber = "";
//    }
//
//    public long getId() {
//        return this.id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return this.firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public BigDecimal getSalary() {
//        return this.salary;
//    }
//
//    public void setSalary(BigDecimal salary) {
//        this.salary = salary;
//    }
//
//    public Date getHireDate() {
//        return this.hireDate;
//    }
//
//    public void setHireDate(Date hireDate) {
//        this.hireDate = hireDate;
//    }
//
//    public String getJobID() {
//        return this.jobID;
//    }
//
//    public void setJobID(String jobID) {
//        this.jobID = jobID;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return this.phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String toString() {
//        return "Employee{id=" + this.id + ", firstName='" + this.firstName + "', lastName='" + this.lastName + "', salary=" + this.salary + ", hireDate='" + this.hireDate + "', jobID='" + this.jobID + "', email='" + this.email + "', phoneNumber='" + this.phoneNumber + "'}";
//    }
}


