<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <!-- Retrieval -->
    <c:set var="params" value="${requestScope.params}"/>

	<h1>Profile Details (GET)</h1>
	<table>
		<tr>
			<td>Param Name</td>
			<td>Param Value</td>
		</tr>
		<c:forEach var="p" items="${params}">
		<tr>
			<td><c:out value="${p[0]}" /></td>
			<td><c:out value="${p[1]}" /></td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>