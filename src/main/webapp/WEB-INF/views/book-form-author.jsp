<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h2>${errorMessage}</h2>
        <h3>Welcome, Enter The Book Details</h3>
        <form:form method="POST" action="/sp-cources/book/edit" modelAttribute="book">
             <table>
                <tr>
                <td></td>
                    <td><form:label path="name">name</form:label></td>
                    <td><form:input path="name" disabled="true"/></td>
                </tr>
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
                <td></td>
                    <td><form:label path="author.lastName">author.lastName</form:label></td>
                    <td><form:input path="author.lastName" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
                    <td><form:label path="author.dateOfBirth">author.dateOfBirth</form:label></td>
                    <td><form:input path="author.dateOfBirth" type="date" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:errors path="author" cssClass="error" /></td>
                    <td><form:label path="author">EDIT AUTHORS</form:label></td>
                    <td><form:select path="author">
                        <%-- <form:option value="-" label="--Please Select"/> --%>
                        <form:options items="${authors}" itemValue="id" itemLabel="firstName"/>
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