<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sleep Duration Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        p {
            background: #fff;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: red;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 3px;
        }
        a:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Results</h1>
    <%
        Long totalDaysAlive = (Long) request.getAttribute("totalDaysAlive");
        Long totalSleepHours = (Long) request.getAttribute("totalSleepHours");
        String error = (String) request.getAttribute("error");

        if (error != null) {
    %>
        <h2><%= error %></h2>
    <%
        } else {
    %>
        <p>You have been alive for <strong><%= totalDaysAlive %> days</strong>.</p>
        <p>You have slept <strong><%= totalSleepHours %> hours</strong>.</p>
    <%
        }
    %>
    <a href="sleep">Back to Form</a>
</body>
</html>
