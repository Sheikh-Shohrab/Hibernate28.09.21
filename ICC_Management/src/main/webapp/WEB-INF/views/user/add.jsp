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
			<form:form action="${pageContext.request.contextPath }/user/add" modelAttribute="user">
				<div class="row">
					
					<%-- <div class="col-12">
						<label>User ID:</label>
						<form:input path="id" />
					</div> --%>
					
					<div class="col-12">
						<label>Name:</label>
						<form:input path="userName" />
					</div>
					
					<div class="col-12">
	                    <div class="form-group">
	                        <label>Gender</label>
	                        <form:radiobuttons path="gender" items="${genders}" ></form:radiobuttons>
	                    </div>
                	</div>
					
					<div class="col-12">
						<label>Age:</label>
						<form:input path="age" />
					</div>
					
					<div class="col-12">
						<input type="submit" name="submit" value="Add User">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp"/>
