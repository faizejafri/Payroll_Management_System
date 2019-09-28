package com.payrollsystem.dao;

import com.payrollsystem.dbutil.MyConnection;
import com.payrollsystem.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Connection conn = new MyConnection().getConn();

    @Override
    public boolean isValidEmployee(Employee employee) {
        PreparedStatement st = null;
        String sql = "SELECT * FROM TBL_EMPLOYEE WHERE USERNAME=? AND PASSWORD=?";
        boolean res = false;
        ResultSet rs = null;

        try {
            //create prepared stmt

            st = conn.prepareStatement(sql);
            st.setString(1, employee.getUsername());
            st.setString(2, employee.getPassword());

//exec.
            rs = st.executeQuery();
            if (rs.next()) {
                res = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return res;

    }

    @Override
    public String addEmployee(Employee employee) {
        String res = "FAIL";
        String sql = "INSERT INTO TBL_EMPLOYEE(NAME,EMP_ID,PHONE,EMAIL,DESIGNATION,DOB,USERNAME,PASSWORD,USERTYPE)VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmp_id());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getDesignation());
            ps.setDate(6, new java.sql.Date(employee.getDob().getTime()));
            ps.setString(7, employee.getUsername());
            ps.setString(8, employee.getPassword());
            ps.setString(9, employee.getUsertype());

            int r = ps.executeUpdate();
            if (r > 0) {
                res = "SUCCESS";
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String res = "FAIL";

        String sql = "UPDATE TBL_EMPLOYEE SET NAME=?,PHONE=?,EMAIL=?,DESIGNATION=?,DOB=?,USERNAME=?,PASSWORD=?,USERTYPE=?"
                + " WHERE EMP_ID=?";

        PreparedStatement ps = null;

        try {

            //Statement creation
            ps = conn.prepareStatement(sql);

            //set the parameter value
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getPhone());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getDesignation());
            ps.setDate(5, new java.sql.Date(employee.getDob().getTime()));
            ps.setString(6, employee.getUsername());
            ps.setString(7, employee.getPassword());
            ps.setString(8, employee.getUsertype());
            ps.setString(9, employee.getEmp_id());

            //Execute the statement
            int r = ps.executeUpdate();
            if (r > 0) {
                res = "SUCCESS";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String deleteEmployee(Employee employee) {
        PreparedStatement ps = null;
        String sql = "DELETE FROM TBL_EMPLOYEE WHERE EMP_ID=?";
        String res = "fail";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getEmp_id());

            int r = ps.executeUpdate();
            if (r > 0) {
                res = "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList();
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM TBL_EMPLOYEE";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                String emp_id = rs.getString("emp_id");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String designation = rs.getString("designation");
                Date dob = rs.getDate("dob");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String usertype = rs.getString("usertype");

                Employee emp = new Employee(name, emp_id, phone, email, designation, dob, username, password, usertype);
                list.add(emp);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Employee findById(String employeeId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM TBL_EMPLOYEE WHERE EMP_ID=?";
        Employee e = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String emp_id = rs.getString("emp_Id");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String designation = rs.getString("designation");
                Date dob = rs.getDate("dob");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String usertype = rs.getString("usertype");

                e = new Employee(name, emp_id, phone, email, designation, dob, username, password, usertype);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;
    }

    @Override
    public String getUserType(String username) {
        String userType = "";
        String sql = "SELECT USERTYPE FROM TBL_EMPLOYEE WHERE USERNAME=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                userType = rs.getString("userType");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return userType;
    }

    @Override
    public String getName(String username) {
        String name = "";
        String sql = "SELECT NAME FROM TBL_EMPLOYEE WHERE USERNAME=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql); //creation of preapared stmt
            ps.setString(1, username);  //giving or setting value corressponding to ?
            rs = ps.executeQuery();   //executing the statement 
            if (rs.next()) {   //checking whether the corresp. column is present or not 
                name = rs.getString("name");   //getting the name column
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return name;
    }
}
