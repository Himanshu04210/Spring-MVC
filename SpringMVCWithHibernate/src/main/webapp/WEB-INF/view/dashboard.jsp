<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%> 
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
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

        #navbar>a {
            color: white;
            text-decoration: none;
        }

        #navbar p>a {
            text-decoration: none;
            color: white;
            font-size: 22px;
            font-weight: 500;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        table tr td,
        th {
            text-align: center;
            padding: 5px;
        }

        #delete {
            background-color: rgb(231, 77, 77);
            color: white;
            cursor: pointer;
        }

        #delete:hover {
            background-color: red;
        }

        #vaccinate {
            background-color: rgb(71, 170, 71);
            color: white;
            cursor: pointer;
        }

        #vaccinate:hover {
            background-color: green;
        }

        select {
            margin: 15px;
            padding: 5px;
            font-size: 1em;
            background-color: rgb(131, 223, 223);
            border-radius: 7px;
        }
    </style>
    
    <!-- <script src="dashboard.js"></script> -->
<body>
    <div id="navbar">
        <a href="./">
            <h1>Masai Vaccination</h1>
        </a>
        <div>
            <p><a href="register">Rigister</a></p>
            <p><a href="dashboard">Dashboard</a></p>
            <p><a href="<%= request.getContextPath() %>/WEB-INF/view/vaccine.jsp">Vaccinated</a></p>
        </div>
    </div>
    <select name="" id="filterByVaccine">
        <option value="">Filter By Vaccine</option>
        <option value="Covishield">Covishield</option>
        <option value="Covaxin">Covaxin</option>
        <option value="Sputnik">Sputnik</option>
    </select>
    <select name="" id="sortByAge">
        <option value="">Sort By Age</option>
        <option value="h2l">Descending Order</option>
        <option value="l2h">Ascending Order</option>
    </select>
    <select name="" id="filterByPriority">
        <option value="">Filter by priority</option>
        <option value="p0">p0</option>
        <option value="p1">p1</option>
        <option value="p2">p2</option>
        <option value="p3">p3</option>
    </select>
    <button onclick="hello()">click me</button>
    <table border 1>
        <thead>
            <tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Age</th>
                <th>Designation</th>
                <th>Priority</th>
                <th>Vaccine</th>
                <th>OTP</th>
                <th>Vaccinate</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach var="user" items="${userList }">
				<tr>
					<td>${user.getId() }</td>
					<td>${user.getName() }</td>
					<td>${user.getAge() }</td>
					<td>${user.getDesignation() }</td>
					<td>${user.getPriority() }</td>
					<td>${user.getVaccine() }</td>
					<td>
					
						<%
							// Generate a random 4-digit number
					        int min = 1000; // Minimum 4-digit number (inclusive)
					        int max = 9999; // Maximum 4-digit number (inclusive)
					        int randomValue = min + (int)(Math.random() * ((max - min) + 1));
							out.println(randomValue);
						%>
					
					</td>
					<td id="vaccinate">Vaccinate</td>
					<td id="delete">Delete</td>
					
				</tr>
			
			</c:forEach>
        </tbody>
    </table>
</body>
</html>