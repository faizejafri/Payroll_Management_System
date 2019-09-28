<%-- 
    Document   : EmployeeUpdate
    Created on : Jul 24, 2019, 2:47:54 PM
    Author     : Faize
--%>


<%@page import="java.util.List"%>
<%@page import="com.payrollsystem.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>UPDATED EMPLOYEE</title>

    </head>
    <body>

        <%
            //JAVA CODE 
            //Get the list of user from the request(request.set)attribute
            Employee emp = (Employee) request.getAttribute("emp");
            //need to be typecasted
        %>


        <form action="EmployeeUpdateController">
            <table>
                
                <tr>
                    <td>Name:</td> <td><input type="text" name="name" value="<%=emp.getName()%>"</td>
                </tr>

                <tr>
                    <td>Emp_ID:</td>  <td><input type="text" name="emp_id" value="<%=emp.getEmp_id()%>"</td>
                </tr>

                <tr>
                    <td>Phone:</td>   <td><input type="text" name="phone" value="<%=emp.getPhone()%>"</td>
                </tr>

                <tr>
                    <td>Email:</td>   <td><input type="text" name="email" value="<%=emp.getEmail()%>"</td>
                </tr>

                <tr>
                    <td>Designation:</td> <td><input type="text" name="designation" value="<%=emp.getDesignation()%>"</td>
                </tr>

                <tr>
                    <td>DOB:</td> <td><input type="text" name="dob" value="<%=emp.getDob()%>"</td>
                </tr>

                <tr>
                    <td>Username:</td> <td> <input type="text" name="username" value="<%=emp.getUsername()%>" </td>
                </tr>

                <tr>
                    <td>Password:</td> <td><input type="text" name="password" value="<%=emp.getPassword()%>"</td>
                </tr>

                <tr>
                    <td>UserType:</td>  <td><input type="text" name="usertype" value="<%=emp.getUsertype()%>"</td>
                </tr>

                <tr>
                    <td><input type="submit" value="Update"></td>
                </tr>

            </table>
        </form>


    </body>
</html>
