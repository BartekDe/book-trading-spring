<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!doctype html>
<html>
	
	<head>
		<title>
		Home Page
		</title>
	</head>
	<body>
	
		<h2>Welcome to the home page of <i>The Book Trading Club!</i></h2>
		
		<hr>
		
		<p>
			Please log in to see available books.
		</p>
		
		<p>
			<a href="${pageContext.request.contextPath}/books">See books</a> (You need to be logged in)
		</p>
		
		<security:authorize access="!isAuthenticated()">
			<p>
				<a href="${pageContext.request.contextPath}/loginPage">Login</a>
			</p>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<p>
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
					<input type="submit" value="Logout" />
		
				</form:form>
			</p>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<p>
				<a href="${pageContext.request.contextPath}/panel">Admin panel</a>
			</p>
		</security:authorize>
		
	</body>
</html>