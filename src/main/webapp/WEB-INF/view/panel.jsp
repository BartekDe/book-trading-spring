<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
	
	<head>
		<title>
			Admin panel - Books Trading Club
		</title>
	</head>
	<body>
	
		<h2>Admin options:</h2>
		
		<hr>
		
		<p>
			1. delet user
		</p>
		
		<p>
			2. delet postings
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