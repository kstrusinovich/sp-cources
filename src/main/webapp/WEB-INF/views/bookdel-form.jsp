<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>Welcome, Enter The Book Details</h3>
<form:form method="Delete" action="/sp-cources/book/edit" modelAttribute="book">
    <table>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="author.firstName">author.firstName</form:label></td>
            <td><form:input path="author.firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="author.lastName">author.lastName</form:label></td>
            <td><form:input path="author.lastName"/></td>
        </tr>

        <tr>
            <td><input type="delete" value="delete"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>