<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Infomation in detail</h3>
<p>${user.id}</p>
<p>${user.username}</p>
<p>${user.password}</p>
<p>${user.address}</p>
<p>${user.fullname}</p>
<p>${user.infomation}</p>
<p>${user.mail}</p>
<img src="<c:url value='/resources/images/${user.image}'/>" height="100px" width="100px" alt="No avatar"/>