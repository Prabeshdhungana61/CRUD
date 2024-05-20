package com.example.employee.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob; 

    @Column(name = "ssn_last4")
    private String ssnLast4;

    public Employee() {
    }

    public Employee(Long empid, String firstName, String lastName, LocalDate dob, String ssnLast4) {
        this.empid = empid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.ssnLast4 = ssnLast4;
    }

    public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSsnLast4() {
        return ssnLast4;
    }

    public void setSsnLast4(String ssnLast4) {
        this.ssnLast4 = ssnLast4;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", ssnLast4='" + ssnLast4 + '\'' +
                '}';
    }
}
