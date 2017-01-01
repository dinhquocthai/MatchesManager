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
		
		<tr BGCOLOR=#FFAD00>
				<td align=center>Team 1</td>
				<td align=center>Team 2</td>
				<td align=center>Score</td>
				<td align=center>Delete Match</td>
				<!-- <td align=center>Update</td>
				<td align=center>Delete</td> -->
		</tr>
		
		<%-- <c:forEach var="i" begin="0" end="${matches.size() - 1}">
			<tr>
				<c:set var="team1Id" value="${matches[i].getTeam1Id().getTeamId() }"></c:set>
				<c:set var="team2Id" value="${matches[i].getTeam2Id().getTeamId() }"></c:set>
				<td><c:out value="${map[team1Id]}" /></td>
				<td><c:out value="${map[team2Id]}" /></td>
				<td><c:out value="${matches[i].getScore()}" /></td>
				<td>
					<a href="<c:url value="/delete/${matches[i].getId()}"/>" >Delete user</a>
				</td>
			</tr>
		</c:forEach> --%>
		
		<c:forEach var="match" items="${matches}">
			<tr>
				<c:set var="team1Id" value="${match.getTeam1Id().getTeamId() }"></c:set>
				<c:set var="team2Id" value="${match.getTeam2Id().getTeamId() }"></c:set>
				<c:set var="score" value="${match.getScore() }" />
				<td><c:out value="${map[team1Id]}" /></td>
				<td><c:out value="${map[team2Id]}" /></td>
				<td><c:out value="${match.getScore()}" /></td>
				<td>
					<a href="<c:url value="/delete/${match.getId()}"/>" >Delete</a>
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
	<a href="<c:url value="/add"/>" >Add new match</a>
</body>
</html>
