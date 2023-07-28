<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form page</title>
</head>
<body>
	
	<form:form action="submitform" method="POST" modelAttribute="employee">
		name: <form:input path="name" required="true"/>         
        <br><br>  
        address: <form:input  path="address" />  
        <br><br>
        department: <form:input path="department" />  
        <br><br>
         Gender:   
        Male <form:radiobutton path="Gender"  value="male"/>  
        Female <form:radiobutton path="Gender" value="Female"/> 
        <input type="submit" value="Submit" />      
	
	
	</form:form>

</body>
</html>