<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <h3> <a href="/sp-cources/logout"> Logout</a>   <a href="/sp-cources/"> Main</a></h3>
    <hr>
</head>
<body>
<center><h1><font size="5" color="#00008b" >FIND BOOK</font></h1></center>
<form:form method="POST" action="/sp-cources/book/find" modelAttribute="book">
    <table>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="find"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>