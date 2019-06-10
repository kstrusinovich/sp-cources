<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>Welcome, Enter The Book Details</h3>
<form:form method="POST" action="/sp-cources/book/delete" modelAttribute="book">
    <table>
        <tr>
            <td></td>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
            <td><form:label path="id">publishedIn</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
            <td></td>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>