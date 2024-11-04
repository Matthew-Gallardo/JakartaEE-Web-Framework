<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>List of Books</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>List of Books</h1>
    <table>
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
                        <td><c:out value="${book[0]}" /></td>
                        <td><c:out value="${book[1]}" /></td>
                        <td><c:out value="${book[2]}" /></td>
                        <td><c:out value="${book[3]}" /></td>
                        <td><c:out value="${book[4]}" /></td>
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
    <a href="/gallardoweb2/book">Back to Main Menu</a>
</body>
</html>
