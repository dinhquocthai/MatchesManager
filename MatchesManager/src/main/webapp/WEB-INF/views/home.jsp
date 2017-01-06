<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	<head>
		<title>Home</title>
	</head>
<body BGCOLOR=#FDF5E6 align=center>
	<h1>
		Match Manager  
	</h1>

	<table border=1 cellpadding=5 cellspacing= 5 align=center>
		
		<tr BGCOLOR=#FFAD00 align=center>
				<td align=center>Team 1</td>
				<td align=center>Team 2</td>
				<td align=center>Score</td>
				<td align=center>Update</td>
				<td align=center>Delete</td>
		</tr>
		
		<c:forEach var="match" items="${matches}">
			<tr>
				<c:set var="team1Id" value="${match.getTeam1Id().getTeamId() }"></c:set>
				<c:set var="team2Id" value="${match.getTeam2Id().getTeamId() }"></c:set>
				<c:set var="score" value="${match.getScore() }" />
				<td align=center><c:out value="${map[team1Id]}" /></td>
				<td align=center><c:out value="${map[team2Id]}" /></td>
				<td align=center><c:out value="${score}" /></td>
				
				<td align=center>
					<form action="<c:url value="/update_match_page"/>" method="POST">
						<input type="submit" value="Update" />
						<input type="hidden" name="team1Id" value="${team1Id }" />
						<input type="hidden" name="team2Id" value="${team2Id }" />
						<input type="hidden" name="score" value="${score }" />
						<input type="hidden" name="matchId" value="${match.getId() }" />
					</form>
				</td>
				
				<td align=center>
					<%-- <a href="<c:url value="/delete/${match.getId()}"/>" >Delete</a> --%>
					<form action="<c:url value="/delete/${match.getId()}"/>" method="GET">
						<input type="submit" value="Delete" />
					</form>
				</td>
			</tr>
		</c:forEach>
		
		<%-- <c:forEach var="i" begin="0" end="${teams.size()-1}">
			<tr>
				<td>
					<c:out value="${teams[i].getTeamName()}"></c:out>
				</td>
			</tr>
		</c:forEach> --%>
		
		
		<c:if test="${empty matches}">
			No matches added yet
		</c:if>
	</table>
	<br>
	
	<form action="<c:url value="/add_match_page"/>" method="POST">
		<input type="submit" value="Add new match"/>
	</form>
	
	
	
	<form action="<c:url value="/abc"/>" method = "POST">
		<input type="submit" value="abc" />
		<input type="hidden" name="hello" value="hello" />
		<input type="hidden" name="xinchao" value = "xinchao" />
		<input type="hidden" name="number" value = 1 />
	</form> 
</body>
</html>
