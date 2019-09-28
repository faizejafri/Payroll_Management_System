package com.payrollsystem.controller;

import com.payrollsystem.dao.EmployeeDAO;
import com.payrollsystem.dao.EmployeeDAOImpl;
import com.payrollsystem.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "EmployeeUpdateController", urlPatterns = {"/EmployeeUpdateController"})
public class EmployeeUpdateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String emp_id = request.getParameter("emp_id");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String dob = request.getParameter("dob");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        
     
        EmployeeDAO dao = new EmployeeDAOImpl();
        Employee employee = new Employee();

        Date dateOfBirth = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //it is a format ie dd/MM/yyyy
        try {
            dateOfBirth = sdf.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setName(name);
        employee.setEmp_id(emp_id);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setDesignation(designation);
        employee.setDob(dateOfBirth);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setUsertype(usertype);
 
        
        String res = dao.updateEmployee(employee);
        RequestDispatcher rd = null;

        if (res.equals("SUCCESS")) {
            rd = request.getRequestDispatcher("AdminUpdateController");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
