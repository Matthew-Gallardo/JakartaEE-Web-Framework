<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wrong Password</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        color: #333;
        text-align: center;
        padding: 50px;
    }
    h2 {
        color: #e74c3c;
    }
    p {
        font-size: 18px;
    }
    a {
        text-decoration: none;
        color: #3498db;
        font-weight: bold;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <h2>Wrong Password</h2>
    <p>Please Try Again</p>
    <a href="${pageContext.request.contextPath}/book/login_form">Go Back</a>
</body>
</html>