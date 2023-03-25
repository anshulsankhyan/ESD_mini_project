package com.example.erp.Bean;

import jakarta.persistence.*;

@Entity
@Table(name= "employee")
public class Employee {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeID;

    @Column(name="email")
    private String employee_email;

    @Column(name="password")
    private String employee_pass;

    public Employee(int employeeID, String employee_email, String employee_pass) {
        employeeID = employeeID;
        employee_email = employee_email;
        employee_pass = employee_pass;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_pass() {
        return employee_pass;
    }

    public void setEmployee_pass(String employee_pass) {
        this.employee_pass = employee_pass;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + employeeID +
                ", Employee_email='" + employee_email + '\'' +
                ", Employee_pass='" + employee_pass + '\'' +
                '}';
    }
}
