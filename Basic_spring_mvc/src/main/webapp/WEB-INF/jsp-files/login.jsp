<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login form</title>
</head>
<body bgcolor="yellow">

	<form action="loginData" method="POST">
	
		Enter Username :- 
		<input name="username" type="text" />
		<br/>
		<br/>
		Enter Password :- 
		<input name="password" type="text" />
		
		<br/>
		<br/>
		<input id="submit" type="submit" value="logIn" />
	</form>
</body>
</html>