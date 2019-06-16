<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<body>
		<a href="/sp-cources/logout">Logout</a>
		<h2>All books</h2>
		<p><b>Just list:</b><p>
		<pre>
			${booksVariable}
		</pre>
		<p><b>Iterated List:</b><p>
		<ol>
			<c:forEach var="book" items="${booksVariable}">
				<li>
						${book.id}.<a href="/sp-cources/book/edit/${book.id}">${book.name} (${book.publishedIn})&nbsp;&nbsp;&nbsp;</a>
						&nbsp;&nbsp;&nbsp;
						<input type="button" onclick="window.location.href = '/sp-cources/book/editBook/${book.id}'" value="edit book"/>
						<input type="button" onclick="window.location.href = '/sp-cources/book/delete/${book.id}'" value="delete book"/>
						<input type="button" onclick="window.location.href = '/sp-cources/book/editAuthor/${book.id}'" value="edit author"/>
				</li>
			</c:forEach>
		</ol>
	</body>
</html>