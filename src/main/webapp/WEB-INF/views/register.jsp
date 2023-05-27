<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/style.css" rel="stylesheet">
<link href="resources/bootstrap.min.css" rel="stylesheet">
<title>New User</title>
</head>
<body>
	<div class="home">
		<h1>
			Project Tracking <br> Application
		</h1>
		<div class="login-form">
			<h2>New User Registration</h2>
			<form:form action="redirect" method="post" modelAttribute="newUser">
				<form:input type="text" path="username" placeholder="User Name" class="form-control" />
				<form:errors path="username" cssClass="error" />
				<br>
				<form:input type="text" path="email" placeholder="Email" class="form-control" />
				<form:errors path="email" cssClass="error" />
				<br>
				<form:input type="password" path="password" placeholder="Password" class="form-control" />
				<form:errors path="password" cssClass="error" />
				<br>
				<br>
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
			<p>
				Already a member? Login <a href="/project-tracking-app"
					style="color: red;">here</a>
			</p>
		</div>
	</div>
</body>
</html>