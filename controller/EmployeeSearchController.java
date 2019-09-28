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

@WebServlet(name = "EmployeeSearchController", urlPatterns = {"/EmployeeSearchController"})
public class EmployeeSearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String employeeId = request.getParameter("employeeId");

        EmployeeDAO dao = new EmployeeDAOImpl();
        Employee employee = new Employee();
        employee.setEmp_id(employeeId);
        Employee res = dao.findById(employeeId);  //Because Employee is a return type

        RequestDispatcher rd = null;
        if (res != null) {
            request.setAttribute("emp", res);
            rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
            rd.forward(request, response);
        } else {

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
