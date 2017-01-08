<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body BGCOLOR=#FDF5E6 align=center>
	<h1 align=center>Login</h1>

	<center>
		<form name="loginForm" action="<c:url value="/login" />" method="POST" onsubmit="return validation(this)">
			Username: <input type="text" name="username" /><br>
			Password: <input type="password" name="password" /><br>
			<c:if test="${not empty alert }">
				<c:out value="${alert }" />
			</c:if>
			<br>
			<input type="submit" value="Login"/>
		</form>
	</center>
	
	
	<script type="text/javascript">
		function validation(){
			var username = document.forms["loginForm"]["username"].value;
			var password = document.forms["loginForm"]["password"].value;
			if(username == "" || username.trim() == ""){
				alert("Input username");
				return false;
			}
			else if(password == "" || password.trim() == ""){
				alert("Input password");
				return false;
			}
		}
	</script>
</body>
</html>