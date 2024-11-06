<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Result</title>
</head>

<body>
	<!-- JSP Action Tags : Attempt:1  -->
	<jsp:useBean id="add1" class="org.acumen.training.codes.services.AdditionService"
	scope="page"/>
	
	<jsp:setProperty property="param1" name="add1" value="100"/>
	<jsp:setProperty property="param2" name="add1" value="200"/>
	<!-- JSP as XML file -->
	<!-- jsp:body jsp:Expression jsp:element -->
	<!-- Attempt 3: Expression Language -->
	
	<!-- EL implicit objects -->
	<!--  request => requestScope -->
	<!--  session => sessionScope -->
	<!--  page => pageScope -->
	<!--  application => applicationScope -->
	
	<p><c:out value="This is a page"/>  </p>
	<c:set var="id" value="${requestScope.id }"/>
	<c:set var="fname" value="${requestScope.firstname }"/>
	<c:set var="lname" value="${requestScope.lastname }"/>

	
	<h1>Profile Details</h1>
	<!-- Scriptlet -->
	<c:catch var="e">
		<c:set var="salary" value="${requestScope.salary}"/>
	</c:catch>
	<c:if test="${empty e }">
		<c:set var="salary"  value="0"/>
	</c:if>
	<p>ID: <c:out value="${id}" default="NA"/> </p>

	<p>Firstname :<c:out value="${fname}" default="No Firstname"/> </p>
	<p>Lastname :<c:out value="${lname}" default="No Lastname"/> </p>
	<p>Salary :<c:out value="${salary}" default="No Salary"/> </p>
	<p>Sum: <jsp:getProperty property="sum" name="add1"/></p>
	
</body>
</html>