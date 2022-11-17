<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user</title>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
	<p>Form nguoi dung</p>
	<c:url value="/add-user" var="url"/>
	<form:form modelAttribute="user" method="post" action="${url }">
		<form:hidden path="id"/>
		<p>Name</p><form:input path="name"/>
		<p style="color: red;"><form:errors path="name"></form:errors></p>
		<p>Username</p><form:input path="username"/>
		<p style="color: red;"><form:errors path="username"></form:errors></p>
		<p>Password</p><form:input path="password"/>
		<p style="color: red;"><form:errors path="password"></form:errors></p>
		<p>Role</p>
		<form:select path="role">
			<form:option value="admin">Admin</form:option>
			<form:option value="member">Member</form:option>
		</form:select>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>