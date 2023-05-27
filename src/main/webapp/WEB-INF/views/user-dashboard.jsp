<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/project-tracking-app/resources/style.css" rel="stylesheet">
<link href="/project-tracking-app/resources/bootstrap.min.css"
	rel="stylesheet">
<title>Dashboard</title>
</head>
<body>
	<div class="page-wrapper">
		<div class="navbar">
			<button class="btn btn-secondary" type="button" id="userDetails">
				${userDetails.getUsername()}
			</button>
			<h1>Project Tracking App</h1>
			<a href="logout" class="btn btn-secondary" type="button">
				Logout
			</a>
		</div>
		
		<hr>
		
		<div class="data-table">
			<h2>Your Projects 👇</h2>
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th>PID</th>
						<th>Project Name</th>
						<th>Comments</th>
						<th>Status</th>
						<th>User</th>
						<th>Project</th>						
						<th>Operation</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="up" items="${userProjectsList}">
						<tr>
							<td>${up.getPid() }</td>
							<td>${up.getPname() }</td>
							<td>${up.getComments() }</td>
							<td>${up.getStatus() }</td>
							<td>${up.getUser() }</td>
							<td>${up.getProject() }</td>
							<td><a href="updateStatus?pid=${up.getPid()}">Change Project Status</a>
						</tr>
					</c:forEach>
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>