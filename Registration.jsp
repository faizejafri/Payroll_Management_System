<%-- 
    Document   : Registration
    Created on : Jul 23, 2019, 3:44:44 PM
    Author     : Faize
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/registration.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>Register New Employee</title>
        
        <style>
            input[type=text] {
                margin-left: 50px;
            }
            </style>

    </head>

    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </nav>

        <h2 class="title">Register New Employee</h2>
        <hr />

        <div class="container-fluid">       
            ${msg}
            <form action="RegistrationController" method="post">

                <tr>
                    <td>Emp Id</td> <td> <input type="text" value="" name="emp_id" ></td><br>
                <br>
                </tr>     
                
                <tr>
                    <td>Name</td> <td> <input type="text" value="" name="name" ></td><br>
                <br>
                </tr> 

                <tr>
                    <td>Phone</td> <td><input type="text" value="" name="phone"></td><br>
                <br>
                </tr>

                <tr>
                    <td>Email</td> <td><input type="email" value="" name="email" ></td><br>
                <br>
                </tr>

                <tr>
                    <td>Designation</td> <td><input type="text" value="" name="designation" ></td><br>
                <br>
                </tr>

                <tr>
                    <td>User Name</td><td><input type="text" value="" name="username" ></td> <br>
                <br>
                </tr>

                <tr>
                    <td>Password</td><td><input type="password" value="" name="password" ></td><br>
                <br> 
                </tr>

                <tr>
                    <td> Date Of Birth </td> <td><input type="text" value="" name="dob" ></td><br>
                <br>
                </tr>

                <tr>
                    <td>Usertype </td><td><input type="text" value="" name="usertype" maxlength="1" ></td><br>
                <br>
                </tr>

                <tr>
                    <td> <input type="submit" value="Register" name="register"></td>
                </tr>

                <tr>
                    <td><input type="reset" value="clear" ></td>
                </tr>


            </form>
        </div>
    </body>





</html>
