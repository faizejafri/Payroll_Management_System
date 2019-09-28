package com.payrollsystem.dao;

import com.payrollsystem.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    public boolean isValidEmployee(Employee employee);

    public String addEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployee(Employee employee);
    
    public Employee findById(String employeeId);

    public List<Employee> getAll();

    public String getUserType(String username);

    public String getName(String username);
}
