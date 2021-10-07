<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<title>${pageTitle}</title>
<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp"/>
<p style="color: red">${errors}</p>
<body>

   	<h1>${pageTitle}</h1>
   		<div class="row">
		<div class="col-12">
			<form:form action="${pageContext.request.contextPath }/player/add" modelAttribute="player">
					<div class="col-12">
						<%-- <label>Player Type</label>
						<form:input path="playerType" /> --%>
						<label>Select Player Type</label>
						<form:select path="playerType">  
						    <form:option value="Batsman" label="Batsman"/>  
						    <form:option value="Bowler" label="Bowler"/>  
						    <form:option value="All-rounder" label="All-rounder"/>  
						    <form:option value="Wicket-Keeper" label="Wicket-Keeper"/>  
					 	</form:select>
						
					</div>
					
					<div>
						<label>Select Team Name</label>
						<select name="id">
						<c:forEach items="${teams }" var="team">
							<option value="${team.id }">
								${team.teamName }
							</option>
						</c:forEach>
					</select>
					</div>
					
					<div>
						<label>Select Player Name</label>
						<select name="uid">
						<c:forEach items="${users }" var="user">
							<option value="${user.id }">
								${user.userName }
							</option>
						</c:forEach>
					</select>
					</div>
				
					<div class="col-12">
						<input type="submit" name="submit" value="Add Player">
					</div>
			</form:form>
		</div>
	</div>
</body>
</html>
<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp"/>
