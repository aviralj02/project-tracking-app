<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/style.css" rel="stylesheet">
<link href="resources/bootstrap.min.css" rel="stylesheet">
<title>Home</title>
</head>
<body>
	<div class="home">
		<h1>
			Project Tracking <br> Application
		</h1>
		<div class="login-form">
			<h2>User Login</h2>
			<form:form action="client/processing" method="post" modelAttribute="user">
				<form:input type="text" path="username" placeholder="User Name" class="form-control" />
				<br>
				<form:input type="password" path="password" placeholder="Password" class="form-control" />
				<br>
				<br>
				<input type="submit" value="Login" class="btn btn-primary" />
			</form:form>
			<p>
				Not a member? Register <a href="register" style="color: red;">here</a>
			</p>
		</div>
		<p>
			Click <a href="admin/login" style="color: red;">here</a> for Admin
			Login
		</p>
	</div>
</body>
</html>
