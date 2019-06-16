<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>

    </head>
    <body>
        <h2>${errorMessage}</h2>
        <h3>Welcome, Enter The Book Details (AUTHORS)</h3>

        <form:form method="POST" action="/sp-cources/book/editAuthor" modelAttribute="book">
            <table>
                <tr>
                    <td><form:label path="name">name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="publishedIn">publishedIn</form:label></td>
                    <td><form:input path="publishedIn"/></td>
                </tr>

                <tr>
                    <td><form:label path="author">author</form:label></td>
                    <td>
                      <form:select path="author.id">
                          <c:forEach var="author" items="${authors}">
                              <form:option value="${author.id}" label="${author.firstName} ${author.lastName}"/>
                          </c:forEach>
                      </form:select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <%--прячем поле так есть @NotBlank для author.lastName в модели book--%>
                    <td><form:input path="author.lastName" hidden="hidden"/></td>
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