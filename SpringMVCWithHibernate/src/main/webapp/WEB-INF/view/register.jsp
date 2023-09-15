<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%> 
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Register page</title>
</head>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        #navbar {
            background-color: teal;
            display: flex;
            justify-content: space-between;
            color: white;
            padding: 15px 30px;
            align-items: center;

        }

        #navbar>div {
            display: flex;
            width: 40%;
            justify-content: space-around;
        }
        #navbar>a{
            color: white;
            text-decoration: none;
            
        }
        #navbar p>a {
            text-decoration: none;
            color: white;
            font-size: 22px;
            font-weight: 500;
        }

        #heading {
            margin-top: 20px;
            text-align: center;
        }

        input {
            display: block;
            width: 95%;
            margin: 10px 0px;
            padding: 5px 
        }
        #submit{
            width: 100%;
            background-color: rgb(29, 158, 158);
            color: white;
            border: none;
            padding: 7px;
            font-size: 1.1em;
            border-radius: 20px;
            cursor: pointer

        }
        #submit:hover{
            background-color: teal;
        }
        #employee,
        #student {
            display: inline;
            width: 50px;
        }

        form {
            width: 340px;
            height: 60vh;
            padding: 20px 30px;
            margin: 30px auto;
            box-shadow: rgba(9, 30, 66, 0.25) 0px 4px 8px -2px, rgba(9, 30, 66, 0.08) 0px 0px 0px 1px;
        }
        label{
            margin: 10px 0px;
        }
        select{
            margin: 5px;
            padding: 5px;
            font-size: 1em;
        }

    </style>
<body>
	
	<div id="navbar">
        <a href=""><h1>Masai Vaccination</h1></a>
        <div>
            <p><a href="register">Rigister</a></p>
            <p><a href="Dashboard">Dashboard</a></p>
            <p><a href="Vaccinated">Vaccinated</a></p>
        </div>
    </div>
	<h1 id="heading">Fill your cridentials</h1>

	<form:form action="registerEmployee" modelAttribute="user" method="POST">
		
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Enter your name" required>
        <label for="age">Age</label>
        <input type="number" id="age" name="age" placeholder="Age" required>
        <label for="">Designation:- </label>
        <input type="radio" name="Designation" value="employee" id="employee">
        <label for="employee">Employee</label>
        <input type="radio" name="Designation" value="student" id="student">
        <label for="student">Student</label>
        <select name="priority" id="Priority" required>
            <option value="">Select the Priority</option>
            <option value="p0">p0</option>
            <option value="p1">p1</option>
            <option value="p2">p2</option>
            <option value="p3">p3</option>
        </select>
        <select name="vaccine" id="Vaccine" required>
            <option value="">Select which vaccine you prefer</option>
            <option value="Covishield">Covishield</option>
            <option value="Covaxin">Covaxin</option>
            <option value="Sputnik">Sputnik</option>
        </select>
        <input type="submit" id="submit">
		
	</form:form>
</body>
</html>