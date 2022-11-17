<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Product</title>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
	<p>Form san pham</p>
	<c:url value="/search-product" var="url"/>
	<form:form modelAttribute="product" method="post" action="${url}">
		<form:hidden path="id"/>
		<p>Name</p><form:input path="name"/>
		<p style="color: red;"><form:errors path="name"></form:errors></p>
<%-- 		<p>Price</p><form:input path="price"/> --%>
<%-- 		<p style="color: red;"><form:errors path="price"></form:errors></p> --%>
<%-- 		<p>Quantity</p><form:input path="quantity"/> --%>
<%-- 		<p style="color: red;"><form:errors path="quantity"></form:errors></p> --%>
<%-- 		<p>Description</p><form:input path="description"/> --%>
<%-- 		<p style="color: red;"><form:errors path="description"></form:errors></p> --%>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>