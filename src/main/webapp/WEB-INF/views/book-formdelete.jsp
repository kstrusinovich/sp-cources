<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <h3> <a href="/sp-cources/logout"> Logout</a>   <a href="/sp-cources/"> Main</a></h3>
    <hr>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>DELETE BOOK</h3>
<form:form method="POST" action="/sp-cources/book/delete" modelAttribute="book">
    <table>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Delete"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>