package com.payrollsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payrollsystem.dao.EmployeeDAO;

import com.payrollsystem.dao.EmployeeDAOImpl;

import com.payrollsystem.model.Employee;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read the data from the HTTP Request
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        
        // Create the user Object
        Employee emp = new Employee();

        // Set the data to user object
        emp.setUsername(username);
        emp.setPassword(password);

        // Create the DAO object
        EmployeeDAO dao = new EmployeeDAOImpl();
        boolean res = dao.isValidEmployee(emp);
        String userType = dao.getUserType(username);
        String name = dao.getName(username); //giving username to get name of the corresponding name.......

        // Dispatch
        RequestDispatcher rd = null;
        if (res) {
            if (userType.equals("a")) {
                request.setAttribute("msg", "Administrator user login Success");
                rd = request.getRequestDispatcher("Administrator.jsp");
            } else if (userType.equals("e")) {
                request.setAttribute("msg", "Employee login Success");
                request.setAttribute("name", name);
                rd = request.getRequestDispatcher("Employee.jsp");
            } else {
                request.setAttribute("msg", "Please enter valid username and password");
                rd = request.getRequestDispatcher("login.jsp");
            }
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
        return "Short description";
    }
}
