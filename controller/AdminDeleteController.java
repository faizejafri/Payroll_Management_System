package com.payrollsystem.controller;

import com.payrollsystem.dao.EmployeeDAO;
import com.payrollsystem.dao.EmployeeDAOImpl;
import com.payrollsystem.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminDeleteController", urlPatterns = {"/AdminDeleteController"})
public class AdminDeleteController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDAO dao = new EmployeeDAOImpl();
        List<Employee> list = dao.getAll();
        RequestDispatcher rd = request.getRequestDispatcher("AdminDelete.jsp");
        request.setAttribute("list", list);
        rd.forward(request, response);

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