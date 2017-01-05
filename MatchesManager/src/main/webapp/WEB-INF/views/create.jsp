<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Match</title>
</head>

<body BGCOLOR=#FDF5E6 align=center>
	<h1>Create Match</h1>
	<p>(Choose 2 different teams)</p>
	
	<form action="<c:url value="/add" />" method="POST">
		<table border=1 cellpadding=5 cellspacing= 5 align=center>
			<tr BGCOLOR=#FFAD00>
				<td align=center>Team 1</td>
				<td align=center>Team 2</td>
				<td align=center>Score</td>
			</tr>
			
			<tr>
				<td>
					<select name="team1Id">
						<c:forEach var="team" items="${teams }">
							<option value="${team.getTeamId() }"><c:out value="${team.getTeamName() }"/></option> 
						</c:forEach>
					</select>
				</td>
				
				<td>
					<select name="team2Id">
						<c:forEach var="team" items="${teams }">
							<option value="${team.getTeamId() }"><c:out value="${team.getTeamName() }"/></option> 
						</c:forEach>
					</select>
				</td>
				
				<td>
					<input type="text" name="score" />
				</td>
			</tr>
		</table>
		<c:if test="${not empty alert }">
			<c:out value="${alert }" />
		</c:if>
		<br>
		<input type="submit" value="Add match" />
		
		
	</form>
	
	<form action="<c:url value="/" />" >
		<input type="submit" value="Back to home" />	
	</form>
</body>
</html>