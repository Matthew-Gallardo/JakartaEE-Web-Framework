<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete Book Record</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { margin-bottom: 20px; }
        label { margin-top: 10px; }
        button { margin-top: 10px; }
    </style>
</head>
<body>
    <h1>Delete Book</h1>
    <form action="/gallardoweb2/book/delete_book" method="post">
        <label for="title">Select Book Title to Delete:</label>
        <select name="title" id="title" required>
            <c:forEach var="book" items="${bookList}">
                <option value="${book[1]}"><c:out value="${book[1]}" /></option>
            </c:forEach>
        </select>
        <button type="submit">Delete</button>
    </form>
    <a href="/gallardoweb2/book">Back to Main Menu</a>
</body>
</html>
