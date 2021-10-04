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
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<th>${ user.id }</th>
				<th>${ user.userName}</th>
				<th>${ user.age }</th>
				<th>${ user.gender }</th>
				<th><a href="edit?id=${ user.id }">Edit</a></th>
				<th><a href="details?id=${ user.id }">Details</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp"/>
