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
<h3>Welcome, change author</h3>
<form:form method="POST" action="/sp-cources/book/editA" modelAttribute="book">

     <pre>
             ${bookVar}
     </pre>
    <pre>
            ${authors}
    </pre>
    <table>
        <%--<tr>
            <td><form:label path="author">author</form:label></td>
            <td>
                <form:select path="author.id">
                    <c:forEach var="author" items="${authors}">
                        <form:option value="${author}" label="${author.firstName} ${author.lastName}"/>
                    </c:forEach>
                </form:select>
            </td>
            <td></td>
        </tr>--%>
    </table>
</form:form>
</body>
</html>
</html>
