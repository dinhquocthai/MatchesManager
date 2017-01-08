<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	<head>
		<title>Home</title>
	</head>
<body BGCOLOR=#FDF5E6 align=center>
	<h1 align=center>
		Match Manager  
	</h1>
	
	<c:choose>
		<c:when test="${login == true }">
			<p align=center>Welcome!</p>
		</c:when>
	</c:choose>
	
	
	<c:choose>
		<c:when test="${empty matches}">
			<c:out value="No match found." />
		</c:when>
		<c:otherwise>
		<br>	
			<table border=1 cellpadding=5 cellspacing= 5 align=center>
				<tr BGCOLOR=#FFAD00 align=center>
					<td align=center>Team 1</td>
					<td align=center>Team 2</td>
					<td align=center>Score</td>
					<c:choose>
						<c:when test="${login == true }">
							<td align=center>Update</td>
							<td align=center>Delete</td>
						</c:when>
					</c:choose>
					
				</tr>
		
				<c:forEach var="match" items="${matches}">
					<tr>
						<c:set var="team1Id" value="${match.getTeam1Id().getTeamId() }"></c:set>
						<c:set var="team2Id" value="${match.getTeam2Id().getTeamId() }"></c:set>
						<c:set var="score" value="${match.getScore() }" />
						<td align=center><c:out value="${map[team1Id]}" /></td>
						<td align=center><c:out value="${map[team2Id]}" /></td>
						<td align=center><c:out value="${score}" /></td>
						
						<c:choose>
							<c:when test="${login == true }">
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
									<form action="<c:url value="/delete/${match.getId()}"/>" method="GET">
										<input type="submit" value="Delete" />
									</form>
								</td>
							</c:when>
						</c:choose>
						
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
	
	<br>
	<c:choose>
		<c:when test="${login == true }">
			<table align = center>
				<tr>
					<td>
						<form action="<c:url value="/add_match_page"/>" method="POST">
							<input type="submit" value="Add new match"/>
						</form>
					</td>
					<td>
						<form action="<c:url value="/search_page" />" method="POST" >
							<input type="submit" value="Search match" />
						</form>
					</td>
					<td>
						<form action="<c:url value="/logout" />" method="POST" >
							<input type="submit" value="Log out" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table align=center>
				<tr>
					<td>
						<form action="<c:url value="/search_page" />" method="POST" >
							<input type="submit" value="Search match" />
						</form>
					</td>
					<td>
						<form action="<c:url value="/login_page" />" method="POST" >
							<input type="submit" value="Log in" />
						</form>
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	
</body>
</html>
