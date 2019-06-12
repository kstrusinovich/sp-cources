<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<h2>${errorMessage}</h2>
<h3>Edit BOOK</h3>
                <ol>
                        		<c:forEach var="author" items="${authors}">
                        			<li>${author.id}. ${author.firstName} ${author.lastName}</li>
                        		</c:forEach>
                    </ol>
             <form:form method="POST" action="/sp-cources/book/redit" modelAttribute="book">
    <table>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
             <td><form:label path="name">name</form:label></td>
             <td><form:input path="name"/></td>
        </tr>
        <tr>
             <td><form:label path="publishedIn">publishedIn</form:label></td>
             <td><form:input path="publishedIn"/></td>
        </tr>
          <tr>
                             <td><form:label path="author">authorName</form:label></td>
                             <td>
                               <form:select path="author.id">
                               		<c:forEach var="author" items="${authors}">
                                     <form:option value="${author}" label="${author.firstName} ${author.lastName}"/>
                                   </c:forEach>
                               </form:select>
                             </td>
          </tr>
        <tr>
              <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
              <td><form:label path="author.dateOfBirth">author.dateOfBirth</form:label></td>
              <td><form:input path="author.dateOfBirth" type="date"/></td>
       </tr>
        <tr>
            <td><input type="submit" value="Edit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>