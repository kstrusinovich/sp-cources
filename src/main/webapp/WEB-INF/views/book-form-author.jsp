<%--
  Created by IntelliJ IDEA.
  User: MARIA
  Date: 10.06.2019
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>Welcome, Enter The Book Details</h3>
<form:form method="POST" action="/sp-cources/book/edita" modelAttribute="book">
    <table>
        <%--<tr>
            <td></td>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name" disabled="true"/></td>
        </tr>--%>
       <%--     <pre>
                    ${bookVar}
            </pre>
            <pre>
                    ${authorVariable}
            </pre>
            <ol>
                <c:forEach var="book" items="${bookVar}">
                    <li>${book.id}. ${book.name} (${book.publishedIn})</li>
                </c:forEach>
            </ol>--%>
            <tr>
                <td></td>
                <td><form:label path="book.name">book.name</form:label></td>
                <td><form:select path="book.name" ></td>
            <ol>
                <c:forEach var="book" items="${bookVar}">
                    <form:option value="${book.name}">${{book.name}}</form:option>
                </c:forEach>
            </ol>
                </form:select>
            <tr>
            <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
            <td><form:label path="publishedIn">publishedIn</form:label></td>
            <td><form:input path="publishedIn" disabled="true"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:label path="author.firstName">author.firstName</form:label></td>
            <td><form:input path="author.firstName" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="author.lastName">author.lastName</form:label></td>
            <td><form:select path="author.lastName" ></td>
            <ol>
                <c:forEach var="author.lastName" items="${authorVariable}">
                    <form:option value="${author.lastName}">${{author.lastName}}</form:option>
                </c:forEach>
            </ol>
            </form:select>
            <td></td>
        </tr>
        <tr>
            <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
            <td><form:label path="author.dateOfBirth">author.dateOfBirth</form:label></td>
            <td><form:input path="author.dateOfBirth" type="date" disabled="true"/></td>
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
</html>
