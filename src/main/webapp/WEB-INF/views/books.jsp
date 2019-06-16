<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<script type="text/javascript">
function findGo() {
	var ref = "/sp-cources/book/find/" + (document.getElementById('findName').value == "" ? "all" : document.getElementById('findName').value);
	//alert(ref);
	document.location.href=ref;
}
</script>

<body>
	<a href="/sp-cources/logout">Logout</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/sp-cources/book/list">All books</a>

	<h2>All books</h2>

	<p><b>Just list:</b><p>
<pre>
	${booksVariable}
</pre>

	<p><b>Iterated List:</b><p>

	<h2>${errorMessage}</h2>
	
	Name:<input id="findName"/>
	<input value="FIND" onclick="findGo();" type="button">
	<br><br>
	<input value="NEW" onclick="document.location.href='/sp-cources/book/edit'" type="button">
			
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
				<td>&nbsp;&nbsp;<a href="/sp-cources/book/delete/${book.id}">DEL BOOK</a>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;<a href="/sp-cources/book/edit/${book.id}">EDIT BOOK</a>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;<a href="/sp-cources/book/editAuthor/${book.id}">EDIT AUTHOR</a>&nbsp;&nbsp;</td>
			</tr>
		</c:forEach>
	</table>
	<%--
	<ol>
		<c:forEach var="book" items="${booksVariable}">
			<li>${book.id}. ${book.name} (${book.publishedIn}) <a href="/sp-cources/book/delete/${book.id}">DEL</a> </li>
		</c:forEach>
	</ol>
	--%>
</body>
</html>