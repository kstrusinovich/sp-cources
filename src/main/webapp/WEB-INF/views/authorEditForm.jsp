<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<title>Edit author</title>
<h2>${errorMessage}</h2>
<h3>Welcome, Enter The Author Details</h3>
<form:form method="POST" action="/book/edit" modelAttribute="author">
    <table>
        <tr>
            <td><form:label path="firstName">firstName</form:label></td>
            <td><form:input path="firstName"/></td>
            <td></td>
        </tr>
        <tr>
            <td><form:label path="lastName">lastName</form:label></td>
            <td><form:input path="lastName"/></td>
            <td></td>
        </tr>
        <tr>
            <td><form:label path="dateOfBirth">dateOfBirth</form:label></td>
            <td><form:input path="dateOfBirth" type="date"/></td>
            <td><form:errors path="dateOfBirth" cssClass="error" /></td>
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
