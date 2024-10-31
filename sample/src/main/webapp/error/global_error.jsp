<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Error Details </h1>
<p>Error Type: <c:out value="${requestScope.exception_type }"/> </p>
<p>Error Message: <c:out value="${requestScope.exception_msg }"/></p>
<p>Status code: <c:out value="${requestScope.servlet_name }"/></p>
<p>Servlet name:<c:out value="${requestScope.status_code }"/></p>
<p>URI:<c:out value="${requestScope.uri }"/></p>
</body>
</html>