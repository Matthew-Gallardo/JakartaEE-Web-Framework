<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Profile Form Page</h1>
     <form action="/sample/profile/request.html" method="POST">
        ID: <input type="text" name="id"><br/>
        FirstName: <input type="text" name=firstname><br/>
        LastName: <input type="text" name=lastname><br/>
        Salary: <input type="text" name=salary><br/>
        Color: <input type="radio" name="color" value="red">RED&nbsp;
               <input type="radio" name="color" value="blue">BLUE&nbsp;
               <input type="radio" name="color" value="yellow">YELLOW<br/>
        Food: <input type="checkbox" name="food" value="garlic soy chicken">Garlic Soy Chicken&nbsp;
              <input type="checkbox" name="food" value="sinigang">Sinigang&nbsp;
              <input type="checkbox" name="food" value="burger patty">Burger Patty<br/>
        Comment: <textarea name="comment" rows="10" cols="50"></textarea>
        <input type="hidden" name="token" value="1234567" />
        <input type="submit" value="Add Profile" />
     </form>
     <br/>
     <a href="/sample/profile/request.html?id=101&firstname=Juan&lastname=Luna">Click Profile</a>
</body>
</html>