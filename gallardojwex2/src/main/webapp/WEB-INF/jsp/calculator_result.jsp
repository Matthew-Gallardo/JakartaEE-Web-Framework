<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Calculation Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .result {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            max-width: 400px;
            margin: auto;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 16px;
            color: #555;
        }
    </style>
</head>
<body>
    <jsp:useBean id="calculatorService" class="org.acumen.training.codes.services.CalculatorService" scope="request" />

    <div class="result">
        <h2>Calculation Result</h2>
        
        <p>The result of calculating 
            <jsp:getProperty name="calculatorService" property="operand1" />
            <jsp:getProperty name="calculatorService" property="operator" />
            <jsp:getProperty name="calculatorService" property="operand2" />
            is 
            <jsp:getProperty name="calculatorService" property="result" />
        </p>
    </div>
    
</body>
</html>
