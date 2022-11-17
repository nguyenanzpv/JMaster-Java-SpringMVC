<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View User</title>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"
	type="text/css">
</head>
<body>
	<h1>Thong tin nguoi dung</h1>
	<p>ID:${user.id }</p>
	<p>Name:${user.name }</p>
	<p>Username:${user.username }</p>
	<p>Password:${user.password }</p>
	<p>Role:${user.role }</p>
</body>
</html>