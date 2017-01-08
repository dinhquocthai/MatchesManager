<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Match</title>
</head>
<body BGCOLOR=#FDF5E6 align=center>
	<h1 align=center>Search Match</h1>
	<form action="<c:url value="/search" />" method="POST" >
		<table align=center>
			<tr>
				<td>
					<input list="teams" type="text" name="teamName"  placeholder="Input team name..." />
					<datalist id="teams">
						<option value="Vietnam">
						<option value="Singapore">
						<option value="Malaysia">
						<option value="Indonesia">
						<option value="Thailand">
					</datalist>
				</td>
				<td>
					<input type="submit" value="Search" />
				</td>
			</tr>
		</table>	
	</form>
	
	<br/>
	<c:choose>
		<c:when test="${not empty matches && action == 'search' }">
			<table border=1 cellpadding=5 cellspacing= 5 align=center>
				<tr BGCOLOR=#FFAD00 align=center>
					<td align=center>Team 1</td>
					<td align=center>Team 2</td>
					<td align=center>Score</td>
				</tr>
				
				<c:forEach var="match" items="${matches }">
					<tr>
						<c:set var="team1Id" value="${match.getTeam1Id().getTeamId() }"></c:set>
						<c:set var="team2Id" value="${match.getTeam2Id().getTeamId() }"></c:set>
						<c:set var="score" value="${match.getScore() }" />
						<td align=center><c:out value="${map[team1Id]}" /></td>
						<td align=center><c:out value="${map[team2Id]}" /></td>
						<td align=center><c:out value="${score}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${not empty alert}">
			<c:out value="${alert }" />
		</c:when>
		<c:otherwise>
			<p align=center>Please put team name in the search field</p>
		</c:otherwise>
	</c:choose>
	<br/>
	<center>
		<form action="<c:url value="/" /> " > 
			<input type="submit" value="Back to home" />
		</form>
	</center>
	
</body>
</html>