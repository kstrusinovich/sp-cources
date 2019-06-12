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

			<th>AUTHOR</th>

			<th></th>

			<th></th>

		</tr>
		<c:forEach var="book" items="${booksVariable}">
			<tr>

				<td>${book.id}</td>

				<td>${book.name}</td>

				<td align=center>${book.publishedIn}</td>

				<td>${book.author.firstName}&nbsp;&nbsp;${book.author.lastName}</td>

				<td>&nbsp;&nbsp;<a href="/sp-cources/book/delete/${book.id}">DELETE BOOK</a>&nbsp;&nbsp;</td>

				<td>&nbsp;&nbsp;<a href="/sp-cources/book/edit/${book.id}">EDIT BOOK</a>&nbsp;&nbsp;</td>

				<td>&nbsp;&nbsp;<a href="/sp-cources/book/editAuthor/${book.id}">EDIT AUTHOR</a>&nbsp;&nbsp;</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>