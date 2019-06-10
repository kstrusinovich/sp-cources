<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

	<h2>All books</h2>

	<p><b>Just list:</b><p>
<pre>
	${booksVariable}
</pre>

	<p><b>Iterated List:</b><p>

	<table border="0">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PUBLISHED</th>
			<th></th>
		</tr>
		<c:forEach var="book" items="${booksVariable}">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td align="center">${book.publishedIn}</td>
				<td align="center"><a href="/sp-cources/book/delete/${book.id}">DEL</a></td>
			</tr>
		</c:forEach>
	</table>
	<!--
	<ol>
		<c:forEach var="book" items="${booksVariable}">
			<li>${book.id}. ${book.name} (${book.publishedIn}) <a href="/sp-cources/book/delete/${book.id}">DEL</a> </li>
		</c:forEach>
	</ol>
	-->
</body>
</html>