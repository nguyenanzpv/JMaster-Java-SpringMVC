<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Infomation in detail</h3>
<p>${product.id}</p>
<p>${product.name}</p>
<p>${product.price}</p>
<p>${product.quantity}</p>
<p>${product.description}</p>
<img src="<c:url value='/resources/image/${product.imageUrl}'/>" height="100px" width="100px" alt="No avatar"/>