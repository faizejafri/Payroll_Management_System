package com.payrollsystem.dbutil;

import java.sql.*;

public class MyConnection {
    private Connection conn;

    public Connection getConn() {
        String url="jdbc:mysql://localhost:3306/PAYROLL";
        String username="root";
        String password="";
        String driverClass="com.mysql.jdbc.Driver";
        
        try {  //Load the Driver
            Class.forName(driverClass);
            conn=DriverManager.getConnection(url,username,password);
            System.out.println(" Connection Established ");
        }catch(SQLException e) {
            System.out.println(" Connection Error " + e);
        }catch(ClassNotFoundException e) {
        }
return conn;        
        }
    public static void main(String[] args) {
        MyConnection mc=new MyConnection();
        System.out.println(mc.getConn());
    }
   }
