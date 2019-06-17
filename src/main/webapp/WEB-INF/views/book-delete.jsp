<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>Delete books</h3>

<form:form method="POST" action="/sp-cources/book/delete" modelAttribute="delete">

        <ol>
            <c:forEach var="book" items="${booksVariable}">
                <li>
                <input type="checkbox" name="ids" checked value=${book.id}> ${book.name}
                </li>
            </c:forEach>
        </ol>
        <tr>
            <td></td>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
</form:form>
</body>
</html>