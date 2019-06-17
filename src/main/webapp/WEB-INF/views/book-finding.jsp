<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<h2>${book.name}</h2>

<p>List:<p>

<ol>
    <c:forEach var="book" items="${books}">
        <li> ${book.id} ${book.name} ${book.publishedIn}</a></li>
    </c:forEach>
</ol>
</body>
</html>