<%@page import="com.masai.Entities.Employees"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees Details</title>
</head>
<body>
	<h1>All employee details</h1>
	
	<%
	   List<Employees> employees = (List<Employees>) request.getAttribute("employees");
	   for (Employees employee : employees) {
	%>
	   <p><%= employee.toString() %></p>
	<%
	   }
	%>
</body>
</html>