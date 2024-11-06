<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Form Page</title>
</head>
<body>
	<h1>Profile Form Page</h1>
	<p>Username: <c:out value="${sessionScope.username }"></c:out>  </p>
	<p>Password: <c:out value="${sessionScope.password }"></c:out>  </p>
	<p>Message: <c:out value="${applicationScope.message }"></c:out>  </p>
	<c:url var= "newUrl" value="/profile/request.html"/>
     <form id="form1" action='<c:out value="${newUrl}"/>' method="POST">
        ID: <input type="text" name="id"><br/>
        FirstName: <input type="text" name=firstname><br/>
        LastName: <input type="text" name=lastname><br/>
        Salary: <input type="text" name=salary><br/>
        <c:set var="genderOpts" value="${applicationScope.gender}"/>
        Gender: <select name = "gender">
	        <c:forEach var="g" items="${genderOpts }">
	        <option value="${g}"> <c:out value="${g}"></c:out> </option>
	        </c:forEach>
        </select> <br/>
        Gender:
        Color: <input type="radio" name="color" value="red">RED&nbsp;
               <input type="radio" name="color" value="blue">BLUE&nbsp;
               <input type="radio" name="color" value="yellow">YELLOW<br/>
        Food: <input type="checkbox" name="food" value="garlic soy chicken">Garlic Soy Chicken&nbsp;
              <input type="checkbox" name="food" value="sinigang">Sinigang&nbsp;
              <input type="checkbox" name="food" value="burger patty">Burger Patty<br/>
        Comment: <textarea name="comment" rows="10" cols="50"></textarea>
        <input type="hidden" name="token" value="1234567" />
        <input type="submit" name="form1sub" value="Add Profile" />
     </form>
     <br/>
     <a id ="hyper1" href='<c:out value="${newUrl }"/>?id=101&firstname=Juan&lastname=Luna'>Click Profile</a>
     <a id ="hyper2" href='<c:out value="${newUrl }"/>'>Go Home</a>
</body>
</html>