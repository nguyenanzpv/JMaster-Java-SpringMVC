<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Product</title>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"
	type="text/css">
</head>
<body>
	<h1>Thong tin san pham</h1>
	<p>ID:${product.id }</p>
	<p>Name:${product.name }</p>
	<p>Price:${product.price }</p>
	<p>Quantity:${product.quantity }</p>
	<p>Description:${product.description }</p>
</body>
</html>