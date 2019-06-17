<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form method="POST" action="/sp-cources/book/find" modelAttribute="book">
        <input type="text" name="find"/>
    </form:form>
</body>
</html>