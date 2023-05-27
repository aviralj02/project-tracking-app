<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/project-tracking-app/resources/style.css" rel="stylesheet">
<link href="/project-tracking-app/resources/bootstrap.min.css"
	rel="stylesheet">
<title>Assign</title>
</head>
<body>
	<div class="home">
		<h1>
			Assign Project
		</h1>
		<div class="login-form">
			<form:form action="assign-success" method="post" modelAttribute="userAssign">
				<form:input type="text" path="username" class="form-control" placeholder="User Name"/>
				<br>
				<form:input type="text" path="pid" placeholder="Project ID" class="form-control" />
				<br>
				<br>
				<input type="submit" value="Assign" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>