<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Match</title>
</head>
<body BGCOLOR=#FDF5E6 align=center>
	<h1 align=center>Update Match</h1>
	
	<form name="updateForm" action="<c:url value="/update"/>" method="POST" onsubmit="return validation(this)">
		<table border=1 cellpadding=5 cellspacing= 5 align=center>
			<tr BGCOLOR=#FFAD00>
				<td align=center>Team 1</td>
				<td align=center>Team 2</td>
				<td align=center>Score</td>
				<td align=center>Update</td>
			</tr>
		
			<tr>
				<td>
					<c:out value="${team1Name }" />
				</td>
				
				<td>
					<c:out value="${team2Name }" />
				</td>
				
				<td>
					<input type="text" name="score" value=${score } />
				</td>
				
				<td>
					<input type="submit" value="Update">
					<input type="hidden" name="matchId" value="${matchId }" />
				</td>
			</tr>
		</table>
	</form>
	
	
	<script type="text/javascript">
		function validation(){
			var score = document.forms["updateForm"]["score"].value;
			if(score == "" || score.trim() == ""){
				alert("Input the score");
				return false;
			}
		}
	</script>
</body>
</html>