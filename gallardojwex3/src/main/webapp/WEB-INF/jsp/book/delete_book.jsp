<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <form action="${pageContext.request.contextPath}/book/delete_book" method="post">
        <label for="title">Select Book Title to Delete:</label>
        <select name="title" id="title" required>
            <c:forEach var="book" items="${bookList}">
                <option value="${book.title}"><c:out value="${book.title}" /></option>
            </c:forEach>
        </select>
        <button type="submit">Delete</button>
    </form>
    <a href="${pageContext.request.contextPath}/book">Back to Main Menu</a>
</body>
</html>
