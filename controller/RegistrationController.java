package com.payrollsystem.controller;

import com.payrollsystem.dao.EmployeeDAO;
import com.payrollsystem.dao.EmployeeDAOImpl;
import com.payrollsystem.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrationController", urlPatterns = {"/RegistrationController"})
public class RegistrationController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String emp_id = request.getParameter("emp_id");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String usertype = request.getParameter("usertype");

        //Cast to Date
        Date dateOfBirth = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //it is a format ie dd/MM/yyyy
        try {
            dateOfBirth = sdf.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Employee emp = new Employee();
        emp.setEmp_id(emp_id);
        emp.setName(name);
        emp.setPhone(phone);
        emp.setEmail(email);
        emp.setDesignation(designation);
        emp.setUsername(username);
        emp.setPassword(password);
        emp.setDob(dateOfBirth);
        emp.setUsertype(usertype);
        
        EmployeeDAO dao = new EmployeeDAOImpl();
        String res = dao.addEmployee(emp);
        RequestDispatcher rd = null;             //it is an interface, so ref
        
        if (res.equals("SUCCESS")) {
            request.setAttribute("msg", "Registration Success !!");
            rd = request.getRequestDispatcher("Registration.jsp");
        } else {
            request.setAttribute("msg", "Registration Failure !!");
            rd = request.getRequestDispatcher("Registration.jsp");

        }
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo(); //To change body of generated methods, choose Tools | Templates.
    }
}
