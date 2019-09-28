package com.payrollsystem.controller;

import com.payrollsystem.dao.EmployeeDAO;
import com.payrollsystem.dao.EmployeeDAOImpl;
import com.payrollsystem.model.Employee;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmployeeDeleteController", urlPatterns = {"/EmployeeDeleteController"})
public class EmployeeDeleteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");

        EmployeeDAO edao = new EmployeeDAOImpl();

        Employee employee = new Employee();
        employee.setEmp_id(employeeId);
        String res = edao.deleteEmployee(employee);

        RequestDispatcher rd = null;             //it is an interface, so ref
        if (res.equals("SUCCESS")) {
            rd = request.getRequestDispatcher("AdminDeleteController");
        } else {
            rd = request.getRequestDispatcher("AdminDeleteController");   //Give an Exception condition(Connection error)
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

   
}
