<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/project-tracking-app/resources/style.css" rel="stylesheet">
<link href="/project-tracking-app/resources/bootstrap.min.css" rel="stylesheet">
<title>Projects</title>
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

		<div class="data-table">
			<h2>Project List</h2>
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th>PID</th>
						<th>Project Name</th>
						<th>Comments</th>
						<th>Status</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projectList}">
						<tr>
							<td>${project.getPid() }</td>
							<td>${project.getPname() }</td>
							<td>${project.getComments() }</td>
							<td>${project.getStatus() }</td>
							<td><a href="updateForm?pid=${project.getPid()}">Edit</a>
	
								<a href="deleteRecord?pid=${project.getPid()}"
								onclick="if (!(confirm('Do you really want to delete this project?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
			</tbody>
			</table>
		</div>
		<br>
		<a href="dashboard" class="btn btn-primary">Back</a>
	</div>
</body>
</html>