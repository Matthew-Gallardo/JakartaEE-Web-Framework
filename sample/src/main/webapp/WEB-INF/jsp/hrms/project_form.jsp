<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Form</title>
</head>
<body>
<h1>Project Form Entry</h1>
<form id="projForm" action="/gallardoweb1/project/add" method="POST">
	Project ID <input type="number" name ="id" required/><br/>
	Project Name <input type="text" name ="projectname" required/><br/>
	Project Date <input type="date" name ="projectdate" required/><br/>
	<input type="submit" name ="projectsub" value="Add Project"/><br/>
</form>

</body>
</html>