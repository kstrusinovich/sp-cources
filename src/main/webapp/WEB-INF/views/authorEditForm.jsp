<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<title>Edit author</title>
<h2>${errorMessage}</h2>
<h3>Welcome, Enter The Author Details</h3>
<form:form method="POST" action="/book/edit" modelAttribute="book">
    <table>
        <tr>
            <td><form:label path="author.firstName">author.firstName</form:label></td>
            <td><form:input path="author.firstName"/></td>
            <td></td>
        </tr>
        <tr>
            <td><form:label path="author.lastName">author.lastName</form:label></td>
            <td><form:input path="author.lastName"/></td>
            <td></td>
        </tr>
        <tr>
            <td><form:label path="author.dateOfBirth">author.dateOfBirth</form:label></td>
            <td><form:input path="author.dateOfBirth" type="date"/></td>
            <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>

    </table>
</form:form>

</body>
</html>
