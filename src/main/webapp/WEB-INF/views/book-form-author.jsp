<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    </head>
    <body>
        <h2>${errorMessage}</h2>
        <h3>Welcome, Enter The Book Details</h3>
        <form:form method="POST" action="/sp-cources/book/editAuthor" modelAttribute="book">
             <table>
                <tr>
                <td></td>
                    <td><form:label path="id">ID</form:label></td>
                    <td><form:input path="id" readonly="true"/></td>
                </tr>
                <tr>
                <td></td>
                    <td><form:label path="name">name</form:label></td>
                    <td><form:input path="name" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
                    <td><form:label path="publishedIn">publishedIn</form:label></td>
                    <td><form:input path="publishedIn" readonly="true"/></td>
                </tr>
                <%-- <tr>
                <td></td>
                    <td><form:label path="author.firstName">author.firstName</form:label></td>
                    <td><form:input path="author.firstName" readonly="true"/></td>
                </tr>
                <tr>
                <td></td>
                    <td><form:label path="author.lastName">author.lastName</form:label></td>
                    <td><form:input path="author.lastName" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
                    <td><form:label path="author.dateOfBirth">author.dateOfBirth</form:label></td>
                    <td><form:input path="author.dateOfBirth" type="date" readonly="true"/></td>
                </tr> --%>
                <tr>
                    <td><form:errors path="author.id" cssClass="error" /></td>
                    <td><form:label path="author.id">author</form:label></td>
                    <%-- <td><form:select path="author.id" items="${authors}" /> --%>
                    <%-- <td><form:select path="author.id"><form:options items="${authors}" itemValue="id" itemLabel="firstName"/></form:select>--%>
                    <td>
                    <form:select path="author.id">
                    	<c:forEach var="author" items="${authors}">
                    		<form:option value="${author.id}"><c:out value="${author.firstName} ${author.lastName}"/></form:option>
                    	</c:forEach>
                    </form:select>
                    </td>
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