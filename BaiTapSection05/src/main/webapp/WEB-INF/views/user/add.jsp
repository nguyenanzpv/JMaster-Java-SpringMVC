<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="/user/add" var="url"/>
<form:form modelAttribute="user" method="post" action="${url}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <p>Enter username:</p><form:input path="username"/>
    <form:errors path="username"/>
    <p>Enter password:</p><form:password path="password"/>
    <form:errors path="password"/>
    <p>Enter fullname:</p><form:input path="fullname"/>
    <form:errors path="fullname"/>
    <p>Enter address:</p><form:input path="address"/>
    <form:errors path="address"/>
    <p>Enter phone:</p><form:input path="phone"/>
    <form:errors path="phone"/>
    <p>Enter information:</p><form:input path="infomation"/>
    <form:errors path="infomation"/>
    <p>Enter mail:</p><form:input path="mail"/>
    <form:errors path="mail"/>
    <p>Upload user's image:</p><form:input path="avatar" type="file"/>
    <br>
    <button type="submit">Add user</button>
</form:form>