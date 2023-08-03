<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%-- <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database connection</title>
</head>
<body>
	<h1>Working fine</h1>
	
	
	<%
		String url = "jdbc:mysql://localhost:3306/db2";
		String username = "root";
		String password = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		
		String sql = "insert into employee (gender, name, salary) values (?, ?, ?)";
		
		
		
		String query = "select * from employee";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "female");
		st.setString(2, "Aarju");
		st.setInt(3, 25000);
		
		if(st.executeUpdate() >0) {
			out.println("Employee Added <br>");
		}
		
		ResultSet rs = st.executeQuery(query);
		
		if(!rs.isBeforeFirst() && rs.getRow() == 0) out.println("No product in the database!!!!");
	
		while(rs.next()) {
			out.println("Product Id:- "+rs.getInt(1) + "<br>"); 
			out.println("Name:- "+rs.getString("name")+ "<br>");
			out.println("Quantity:- " +rs.getString("gender")+ "<br>");
			out.println("Price:- "+rs.getInt(4)+ "<br>"+ "<br>");
			
		}
	
		
	
	%>
</body>
</html>