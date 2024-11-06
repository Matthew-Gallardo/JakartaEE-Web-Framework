<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .input-field {
            width: 300px;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .login-btn {
            width: 300px;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .login-btn:hover {
            background-color: #45a049;
        }

        .links {
            display: flex;
            justify-content: space-between;
            font-size: 12px;
            width: 300px;
            margin-top: 10px;
        }

        .links a {
            color: #007bff;
            text-decoration: none;
        }

        .links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <form action="/gallardoweb3/book/login" method="POST">
        <h2>Login</h2>
        
        <input type="text" name="email" class="input-field" placeholder="Username" required><br>
        <input type="password" name="password" class="input-field" placeholder="Password" required><br>
        
        <button type="submit" id="login-btn"class="login-btn">Login</button>

        <div class="links">
            <a href="/gallardoweb3/book/signup">Sign Up</a>
        </div>
    </form>

</body>
</html>
