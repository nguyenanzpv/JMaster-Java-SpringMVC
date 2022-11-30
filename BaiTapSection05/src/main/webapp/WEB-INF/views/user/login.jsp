<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:url value="/login" var="url"/>
<form action="${url}" method="post">
	<input name="username" type="text" placeholder="Type username"/>
	<input name="password" type="password" placeholder="Type password"/>
	<button type="submit">Login</button>
</form>