<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h2>${errorMessage}</h2>
        <h3>Welcome, Enter id to seach for Book</h3>
        <form:form method="POST" action="/sp-cources/book/find" modelAttribute="book">
             <table>
                <tr>
                    <td><form:label path="id">id</form:label></td>
                    <td><form:input path="id"/></td>
                    <td></td>
                </tr>
                <td></td>
                    <td><input type="submit" value="Find"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>