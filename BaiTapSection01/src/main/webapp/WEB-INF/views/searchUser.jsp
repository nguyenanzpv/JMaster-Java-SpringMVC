<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search User</title>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
	<p>Form tim user</p>
	<c:url value="/search-user" var="url"/>
	<form:form modelAttribute="user" method="post" action="${url}">
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
	<p>Danh sach user</p>
	<tabel>
		<th>
			<td>Id</td>
			<td>Name</td>
			<td>Usernam</td>
			<td>Password</td>
			<td>Role</td>
		</th>
		<br/>
		<c:forEach items="${lstUser}" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.role }</td>
			</tr>
			<br/>
		</c:forEach>
	</tabel>
</body>
</html>