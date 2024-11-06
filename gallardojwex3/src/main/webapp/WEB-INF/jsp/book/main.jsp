<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Bookstore Management System</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            margin: 20px; 
            background-color: #f4f4f4; 
            color: #333; 
        }
        h1 { 
            color: #4CAF50; 
        }
        ul { 
            list-style-type: none; 
            padding: 0; 
        }
        li { 
            margin: 5px 0; 
        }
        a { 
            text-decoration: none; 
            color: #007BFF; 
            padding: 8px 12px; 
            border: 1px solid transparent; 
            border-radius: 4px; 
        }
        a:hover { 
            background-color: #007BFF; 
            color: white; 
            border: 1px solid #007BFF; 
        }
    </style>
</head>
<body>
    <h1>Bookstore Management</h1>
    <ul>
        <li><a href="/gallardoweb3/book/add_book">Insert Book</a></li>
        <li><a href="/gallardoweb3/book/list_books.jsp">List Books</a></li>
        <li><a href="/gallardoweb3/book/delete_book">Delete Book</a></li>
        <li><a href="/gallardoweb3/book/update_book">Update Book</a></li>
        <li><a href="/gallardoweb3/book/logout">Logout</a></li>
    </ul>
</body>
</html>
