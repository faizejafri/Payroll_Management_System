<%-- 
    Document   : login
    Created on : Jul 25, 2019, 5:39:05 PM
    Author     : Faize
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>

    </head>
    <body>
        ${msg}

        <h1 class="pagetitle">Payroll Management System</h1>
        <div>
            <h1 class="logintitle">Login Form</h1> 
            <hr>
            <br><br>

            <center>
                <form action="LoginController"> 

                    <table>

                        <tr>
                            <td class="userpass">Username: <input type="text" name="uname" placeholder="Enter Username" /></td>
                        </tr>

                        <tr>
                            <td class="userpass">Password: <input type="password" name="pass" placeholder="Enter Password" /></td>
                        </tr>

                    </table>        
                    <tr>
                        <td> 
                            <input type="submit" value="Login">
                        </td>         
                    </tr>

                </form>
            </center>
        </div>
    </body>
</html>
