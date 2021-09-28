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
				<div class="row">
					<div class="col-12">
						<label>Player Type</label>
						<form:input path="playerType" />
					</div>
					<div class="col-12">
						<label>Player Type</label>
						<form:input path="playerType" />
					</div>
					
					
					<div class="col-12">
						<input type="submit" name="submit" value="Add Player">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp"/>
