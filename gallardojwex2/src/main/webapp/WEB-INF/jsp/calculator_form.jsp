<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    form {
        background: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        max-width: 400px;
        margin: auto;
    }
    label {
        display: block;
        margin: 10px 0 5px;
    }
    input, select, button {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        background-color: #28a745;
        color: white;
        border: none;
        cursor: pointer;
    }
    button:hover {
        background-color: #218838;
    }
</style>
</head>
<body>
  <form action="calculator" method="post">
        <label>First Operand:</label>
        <input type="text" name="operand1" required/><br/>
        
        <label>Second Operand:</label>
        <input type="text" name="operand2" required/><br/>
        
        <label>Operation:</label>
        <select name="operator">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select><br/>
        
        <button type="submit">Calculate</button>
    </form>
</body>
</html>
