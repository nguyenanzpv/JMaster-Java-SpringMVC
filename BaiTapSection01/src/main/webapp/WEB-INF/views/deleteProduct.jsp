<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
	<p>Form Product</p>
	<c:url value="/delete-product/{name}" var="url"/>
	<form:form modelAttribute="product" method="post" action="${url}">
		<form:hidden path="id"/>
		<p>Name</p><form:input path="name"/>
		<p style="color: red;"><form:errors path="name"></form:errors></p>		
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>