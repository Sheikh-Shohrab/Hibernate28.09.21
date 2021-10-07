<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<jsp:include page="../common/header.jsp"/>
<title>${pageTitle}</title>
<body>
	<h1>${pageTitle}</h1>
	<table class="table">
		<tr>
			<th>ID</th>
			<!-- <th>Player Name</th> -->
			<th>Player Type</th>
			<!-- <th>Team Name</th> -->
		</tr>
		<c:forEach items="${players }" var="player">
			<tr>
				<th>${ player.id }</th>
				<%-- <th>${player. team}</th>
				<th>${ }</th> --%>
				<th>${ player.playerType }</th>
				
				<th><a href="edit?id=${ player.id }">Edit</a></th>
				<th><a href="details?id=${ player.id }">Details</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp"/>
