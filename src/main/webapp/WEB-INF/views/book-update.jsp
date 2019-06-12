<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>Updates</h3>
<form:form method="POST" action="/book/update" modelAttribute="book">
    <table>
        <hidden>
            <tr>
                <td><form:label path="id">id</form:label></td>
                <td><form:input path="id"/></td>
                <td></td>
            </tr>
        </hidden>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name"/></td>
            <td></td>
        </tr>
        <tr>
            <td><form:label path="publishedIn">publishedIn</form:label></td>
            <td><form:input path="publishedIn"/></td>
            <td><form:errors path="publishedIn" cssClass="error" /></td>
        </tr>
        <form:select path="author.id">
            <c:forEach items="${authors}">
                <form:option value="-" label="Select author"/>
            </c:forEach>

            <form:options items="${authors}"> ${author.firstName} ${author.lastName} </form:select>
        </form:select>

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