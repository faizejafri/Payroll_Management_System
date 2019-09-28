<%-- 
    Document   : employeeReport
    Created on : Jul 24, 2019, 10:47:55 AM
    Author     : Faize
--%>

<%@page import="java.util.List"%>
<%@page import="com.payrollsystem.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <title>Employee Updated</title>

    </head>
    <body>

        <%
            //JAVA CODE 
            //Get the list of user from the request(request.set)attribute
            List<Employee> list = (List<Employee>) request.getAttribute("list");    //getAttribute-->provides addr, so 
            //need to be typecasted
        %>
    <center><h1>Employees Data</h1></center>
    <br>
    
        <table class="table">
            <thead>

            <th>Name</th>
            <th>Emp_Id</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Designation</th>
            <th>DOB</th>
            <th>Username</th>
            <th>Password</th>
            <th>UserType</th>

        </thead>


        <%
            for (Employee empl : list) {
        %>


        <tbody>

        <td><%=empl.getName()%></td>
        <td><%=empl.getEmp_id()%></td>
        <td><%=empl.getPhone()%></td>
        <td><%=empl.getEmail()%></td>
        <td><%=empl.getDesignation()%></td>
        <td><%=empl.getDob()%></td>
        <td><%=empl.getUsername()%></td>
        <td><%=empl.getPassword()%></td>
        <td><%=empl.getUsertype()%></td>
        <td><a href="EmployeeSearchController?employeeId=<%=empl.getEmp_id()%>">Update</a></td>


    </tbody>

    <%
        }
    %>

</table>

</body>
</html>
