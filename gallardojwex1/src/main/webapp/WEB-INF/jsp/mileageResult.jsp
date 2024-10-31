<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mileage Calculation Result</title>
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
        .highlight {
            font-weight: bold;
            color: #0056b3;
        }
        p {
            font-size: 1.1em;
            margin-bottom: 1em;
        }
        .details {
            font-size: 1.1em;
            padding: 0.5em;
            background-color: #e0f3ff;
            border-left: 4px solid #0056b3;
            margin-bottom: 1em;
        }
        a {
            text-decoration: none;
            color: #0056b3;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Mileage Calculation Result</h2>
    
    <p class="details">
        <strong class="highlight">${name}</strong>, you drove 
        <strong class="highlight">${milesDriven}</strong> miles using 
        <strong class="highlight">${gallonsUsed}</strong> gallons, achieving 
        an average fuel efficiency of <strong class="highlight">${milesPerGallon}</strong> miles per gallon (MPG).
    </p>

    <p><strong>Name:</strong> ${name}</p>
    <p><strong>Miles Driven:</strong> ${milesDriven}</p>
    <p><strong>Gallons Used:</strong> ${gallonsUsed}</p>
    <p><strong>Miles Per Gallon (MPG):</strong> ${milesPerGallon}</p>

    <p><a href="mileage">Back to Form</a></p>
</body>
</html>
