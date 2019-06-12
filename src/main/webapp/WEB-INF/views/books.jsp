<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<table  style="font-family: arial; line-height: 2.0; ">
    <tr>
        <td style="vertical-align: top">
 <h2>Book</h2>

 <a href="/book/edit/">Insert new book</a><br>
	<c:forEach var="book" items="${booksVariable}">
        <li>${book.id}. ${book.name} (${book.publishedIn}) ${book.author.firstName} ${book.author.lastName}
    	    &nbsp; <a href="/book/update/${book.id}">Update</a>   /
            &nbsp; <a href="/book/delete/${book.id}">Delete</a>
        </li>
    </c:forEach>

 </td>
 </tr></table>
</body>
</html>