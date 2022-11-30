<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal" var="user" />
		Welcome, ${user.username }
	<a href="<c:url value='/dang-xuat'/>">Thoat</a>
</security:authorize>

<c:url value="/admin/add" var="url"/>
<form:form modelAttribute="user" method="post" action="${url}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <p><spring:message code="user.username"/>:</p><form:input path="username"/>
    <form:errors path="username"/>
    <p><spring:message code="user.password"/>:</p><form:password path="password"/>
    <form:errors path="password"/>
    <p><spring:message code="user.fullname"/>:</p><form:input path="fullname"/>
    <form:errors path="fullname"/>
    <p><spring:message code="user.address"/>:</p><form:input path="address"/>
    <form:errors path="address"/>
    <p><spring:message code="user.phone"/>:</p><form:input path="phone"/>
    <form:errors path="phone"/>
    <p><spring:message code="user.infomation"/>:</p><form:input path="infomation"/>
    <form:errors path="infomation"/>
    <p><spring:message code="user.mail"/>:</p><form:input path="mail"/>
    <form:errors path="mail"/>
    <p>Upload user's image:</p><form:input path="avatar" type="file"/>
    <br>
    <button type="submit">Add user</button>
</form:form>