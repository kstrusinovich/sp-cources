<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h3> <a href="/sp-cources/logout"> Logout</a>   <a href="/sp-cources/"> Main</a></h3>
    <hr
</head>
<body>
<center><h1><font size="5" color="#00008b" >FIND BOOK</font></h1></center>
    <form:form method="POST" action="/sp-cources/book/find" modelAttribute="book">
     <input type="text" name="query"/>
    </form:form>
</body>
</html>
