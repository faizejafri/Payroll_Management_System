package com.payrollsystem.model;

import java.util.Date;

public class Salary {

    private String id;
    private String emp_id;
    private String name;
    private double basicSalary;
    private double otherSavings;
    private Date date;

    public Salary() {

    }

    public Salary(String id, String emp_id, String name, double basicSalary, double otherSavings, Date date) {
        this.id = id;
        this.emp_id = emp_id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.otherSavings = otherSavings;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOtherSavings() {
        return otherSavings;
    }

    public void setOtherSavings(double otherSavings) {
        this.otherSavings = otherSavings;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}


