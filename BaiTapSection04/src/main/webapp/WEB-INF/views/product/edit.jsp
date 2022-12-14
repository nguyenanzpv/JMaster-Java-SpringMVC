<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>Form san pham</h3>
<c:url value="/product/edit" var = "url"/>
<form:form method="post" modelAttribute="product" action="${url}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <p>Product name: </p><form:input path="name"/>
    <form:errors path="name"/>
    <p>Price: </p><form:input path="price"/>
    <form:errors path="price"/>
    <p>Quantity: </p><form:input path="quantity"/>
    <form:errors path="quantity"/>
    <p>Description: </p><form:textarea path="description"/>
    <p>Product Image: </p><form:input path="imageUrl" type = "file"/>
    <button type="submit">Edit Product</button>
</form:form>