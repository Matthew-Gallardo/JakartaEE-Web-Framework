<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Book Record</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { margin-bottom: 20px; }
        label { display: block; margin-top: 10px; }
        input[type="text"] { width: 200px; padding: 5px; }
        input[type="submit"] { margin-top: 10px; }
    </style>
</head>
<body>
    <form action="/gallardoweb2/book/entry" method="post">
        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" id="isbn"><br>
        
        <label for="title">Title:</label>
        <input type="text" name="title" id="title"><br>
        
        <label for="author">Author:</label>
        <input type="text" name="author" id="author"><br>
        
        <label for="price">Price:</label>
        <input type="text" name="price" id="price"><br>
        
        <label for="qty">Quantity:</label>
        <input type="text" name="qty" id="qty"><br>
        
        <input type="submit" value="Add Book">
    </form>
    <a href="/gallardoweb2/book">Back to Main Menu</a>
</body>
</html>
