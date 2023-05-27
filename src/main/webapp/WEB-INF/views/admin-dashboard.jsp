<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/project-tracking-app/resources/style.css" rel="stylesheet">
<link href="/project-tracking-app/resources/bootstrap.min.css"
	rel="stylesheet">
<title>Home</title>
</head>
<body>
	<div class="page-wrapper">
		<div class="navbar">
			<button class="btn btn-secondary" type="button" id="adminDetails">
				${adminDetails.getAname()}</button>
			<h1>Admin Access</h1>
			<a href="logout" class="btn btn-secondary" type="button"> Logout
			</a>
		</div>

		<hr>

		<div class="admin-home">
			<h2 id="adminDetails">Welcome ${adminDetails.getAname()}</h2>
			<p>Below are some operations you can perform:</p>
			<div class="operations">
				<a class="op" href="project-list"> Project List </a>
				<a class="op" href="add-form"> Add New Project </a>
				<a class="op" href="user-list"> Users List </a>
				<a class="op" href="assign-form"> Assign Projects </a>
			</div>
		</div>
	</div>
</body>
</html>