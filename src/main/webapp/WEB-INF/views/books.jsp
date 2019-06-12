<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

	<h2>All booksSS</h2>

	<p><b>Just list:</b><p>
<pre>
	${booksVariable}
</pre>

	<p><b>Iterated List:</b><p>

	<ol>
		<c:forEach var="book" items="${booksVariable}">
			<li>
					${book.id}. ${book.name} (${book.publishedIn})&nbsp;&nbsp;&nbsp;
					<input type="button" onchange="window.location.href = 'test.php?Date=' value="edit book"/>
			</li>
		</c:forEach>
	</ol>
</body>
</html>