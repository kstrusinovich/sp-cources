<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>Welcome, Enter The Book Details</h3>
<form:form method="Delete" action="/sp-cources/book/delete" modelAttribute="book">
    <table>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="delete"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>