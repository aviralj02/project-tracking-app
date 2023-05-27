<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/project-tracking-app/resources/style.css" rel="stylesheet">
<link href="/project-tracking-app/resources/bootstrap.min.css"
	rel="stylesheet">
<title>Admin</title>
<style>
body{
	background-color: #363434 !important;
}
</style>
</head>
<body>
	<div class="admin">
		<h1>
			Welcome Admin
		</h1>
		<div class="admin-form">
			<h2>Admin Login</h2>
			<form:form action="redirect" method="post" modelAttribute="admin">
				<form:input type="text" path="aname" placeholder="Admin Username" class="form-control" />
				<br>
				<form:input type="password" path="pass" placeholder="Password" class="form-control" />
				<br>
				<br>
				<input type="submit" value="Login" class="btn btn-primary" />
			</form:form>
		</div>
		<p>
			Click <a href="/project-tracking-app/" style="color: red;">here</a> for User
			Login
		</p>
	</div>
</body>
</html>