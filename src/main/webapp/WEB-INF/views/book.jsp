<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<a href="/sp-cources/logout">Logout</a>


<pre>
    ${booksVariable}
</pre>
<h2>${booksVariable}</h2>



    <c:forEach var="book" items="${booksVariable}">
        <h5>${book.name} ${book.id} (${book.publishedIn})</a></h5>
    </c:forEach>

</body>
</html>