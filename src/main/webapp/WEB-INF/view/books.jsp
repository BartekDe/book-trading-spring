<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
	
	<head>
		<title>
			Books - Books Trading Club
		</title>
	</head>
	<body>
	
		<h2>List of available books:</h2>
		
		<hr>
		<!-- add data source for books (hibernate) -->
		<p>
			1. book of fire
		</p>
		
		<p>
			2. book of placeholders
		</p>
		
		<hr>
		
		<p>
			User: <security:authentication property="principal.username" />
			<br>
			Role: <security:authentication property="principal.authorities"/>
		</p>
		
		<hr>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
			<input type="submit" value="Logout" />
		
		</form:form>
		
	</body>
</html>