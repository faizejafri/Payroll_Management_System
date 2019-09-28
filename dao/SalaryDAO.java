package com.payrollsystem.dao;

import com.payrollsystem.model.Salary;
import java.util.List;

public interface SalaryDAO {

    public Salary getSalarybyempid(String emp_id);

    public List<Salary> getAll();

    public Salary generatePayslip(String emp_id, String month);
}
