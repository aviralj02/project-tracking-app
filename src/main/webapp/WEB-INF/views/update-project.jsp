<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/project-tracking-app/resources/style.css" rel="stylesheet">
<link href="/project-tracking-app/resources/bootstrap.min.css"
	rel="stylesheet">
<title>Update Project</title>
</head>
<body>
	<div class="home">
		<h1>
			Update Project Details Below
		</h1>
		<div class="login-form">
			<form:form action="update" method="post" modelAttribute="currProject">
				<form:input type="text" path="pid" class="form-control" readonly="true" />
				<br>
				<form:input type="text" path="pname" placeholder="Project Name" class="form-control" />
				<br>
				<br>
				<form:input type="text" path="comments" placeholder="Comments" class="form-control" />
				<br>
				<br>
				<form:select path="status" modelAttribute="statusList">
					<form:options items="${ statusList }" />
				</form:select>
				<br>
				<br>
				<input type="submit" value="Update" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>