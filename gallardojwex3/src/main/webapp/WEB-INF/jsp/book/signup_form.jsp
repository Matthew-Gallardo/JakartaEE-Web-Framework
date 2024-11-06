<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
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

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .input-field {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .signup-btn {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .signup-btn:hover {
            background-color: #45a049;
        }

        .terms {
            text-align: center;
            font-size: 12px;
            margin-top: 10px;
        }

        .terms a {
            color: #007bff;
            text-decoration: none;
        }

        .terms a:hover {
            text-decoration: underline;
        }

        .terms-checkbox {
            margin-right: 5px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Sign Up</h2>
        <p style="text-align: center;">It's free and only takes a minute</p>

        <form action="/gallardoweb3/book/signup" id="signupForm" name="signupForm" method="POST">
             <input type="text" name="first_name" class="input-field" placeholder="First Name" required><br>
   			 <input type="text" name="last_name" class="input-field" placeholder="Last Name" required><br>
   			 <input type="email" name="email" class="input-field" placeholder="Email" required><br>
   			 <input type="password" name="password" class="input-field" placeholder="Password" required><br>
    		 <input type="password" name="confirmPassword" class="input-field" placeholder="Confirm Password" required><br>
    
		    <label class="terms">
		        <input type="checkbox" class="terms-checkbox" name="terms" required>
		        By clicking the Sign Up button you agree to our 
		        <a href="">Terms and Conditions</a> and
		        <a href="">Privacy Policy</a>.
		    </label><br><br>
		
		    <button type="submit" id="signup-btn" class="signup-btn">Sign Up</button>
        </form>
    </div>

</body>
</html>
