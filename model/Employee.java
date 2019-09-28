package com.payrollsystem.model;

import java.util.Date;

public class Employee {

    private String name;
    private String emp_id;
    private String phone;
    private String email;
    private String designation;
    private Date dob;
    private String username;
    private String password;
    private String usertype;

    
    public Employee() {
    }

    public Employee(String name, String emp_id, String phone, String email, String designation, Date dob, String username, String password, String usertype) {
        this.name = name;
        this.emp_id = emp_id;
        this.phone = phone;
        this.email = email;
        this.designation = designation;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

  
  
}
