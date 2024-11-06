<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Update Book</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { margin-bottom: 20px; }
        label { display: block; margin-top: 10px; }
        input[type="text"], input[type="number"] { margin-top: 5px; width: 100%; }
        button { margin-top: 15px; }
    </style>
</head>
<body>
    <h1>Update Book</h1>
    <form action="/gallardoweb3/book/update_book" method="post">
        <label for="isbn">Select Book ISBN to Update:</label>
        <select name="isbn" id="isbn"  required>
            <c:forEach var="book" items="${bookList}">
                <option value="${book.isbn}">${book.isbn} - <c:out value="${book.title}" /></option>
            </c:forEach>
        </select>
        
        <label for="title">New Title:</label>
        <input type="text" name="title" id="title" placeholder="Leave blank to keep current title">
        
        <label for="author">New Author:</label>
        <input type="text" name="author" id="author" placeholder="Leave blank to keep current author">
        
        <label for="price">New Price:</label>
        <input type="number" step="0.01" name="price" id="price" placeholder="Leave blank to keep current price">
        
        <label for="quantity">New Quantity:</label>
        <input type="number" name="quantity" id="quantity" placeholder="Leave blank to keep current quantity">
        
        <button type="submit">Update Book</button>
    </form>
    <a href="${pageContext.request.contextPath}/book" id="back">Back to Main Menu</a>
</body>
</html>
