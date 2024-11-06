<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>List of Books</title>
</head>
<body>
    <h1>List of Books</h1>
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>

        <c:choose>
            <c:when test="${not empty bookList}">
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td><c:out value="${book.isbn}" /></td>
                        <td><c:out value="${book.title}" /></td>
                        <td><c:out value="${book.author}" /></td>
                        <td><c:out value="${book.price}" /></td>
                        <td><c:out value="${book.quantity}" /></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">No books available.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
    <a href="/gallardoweb3/book" id="back">Back to Main Menu</a>
</body>
</html>
