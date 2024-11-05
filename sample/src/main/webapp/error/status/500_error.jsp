<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1> whahahahahhhahaa 500</h1>
 <p>Exceptiontype <%= exception.getClass().getName() %></p>
 <p>Exception Message <%= exception.getMessage() %></p>
 <p>Exception name: <%= request.getAttribute("jakarta.servlet.error.servlet_name") %></p>
 <p>Exception uri: <%= request.getAttribute("jakarta.servlet.error.request_uri") %></p>
</body>
</html>