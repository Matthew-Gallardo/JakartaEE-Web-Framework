<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project List</title>
</head>
<body>
	<h1>List of Projects</h1>
	<table>
		<tr>
			<td>Project ID</td>
			<td>Project Name</td>
			<td>Project Date</td>
		</tr>
		<c:forEach var="p" items="${requestScope.projects}">
			<tr>
				<td><c:out value="${p.id }"/></td>
				<td><c:out value="${p.projname }"/></td>
				<td><c:out value="${p.projdate }"/></td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>