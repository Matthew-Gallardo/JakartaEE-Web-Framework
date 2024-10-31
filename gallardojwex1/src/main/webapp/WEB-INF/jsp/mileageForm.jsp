<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mileage Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f9f9f9;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #0056b3;
        }
        form {
            background-color: #e0f3ff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="number"] {
            width: calc(100% - 10px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #0056b3;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            border-radius: 4px;
            font-weight: bold;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #004494;
        }
    </style>
</head>
<body>
    <h2>Mileage Calculator</h2>
    <form action="/gallardoweb1/mileage" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required>

        <label for="pricePerGallon">Price Per Gallon:</label>
        <input type="number" name="pricePerGallon" id="pricePerGallon" step="0.01" required>

        <label for="totalAmountPaid">Total Amount Paid:</label>
        <input type="number" name="totalAmountPaid" id="totalAmountPaid" step="0.01" required>

        <label for="initialOdometer">Initial Odometer:</label>
        <input type="number" name="initialOdometer" id="initialOdometer" required>

        <label for="finalOdometer">Final Odometer:</label>
        <input type="number" name="finalOdometer" id="finalOdometer" required>

        <input type="submit" value="Calculate Mileage">
    </form>
</body>
</html>
