<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Task 6</title>
</head>
<body style="font-family: arial; line-height: 1.6;">

	<h2>All books</h2>
<!-- 
	<p><b>Just list:</b><p>
<pre>
	${books}
</pre>
 -->
 <!-- 
	<p><b>Iterated List:</b><p>
 -->
 
	<a href="/sp-cources/book/edit/insert/-1">Insert new book</a><br><br>
		<c:forEach var="book" items="${books}" varStatus="loop">
			${loop.index+1}. <b>«${book.name}»</b> by ${book.author.firstName} ${book.author.lastName}, publ. in ${book.publishedIn}
			&nbsp; &nbsp; [ <a href="/sp-cources/book/edit/update/${book.id}">Update</a>
			&nbsp; <a href="/sp-cources/book/edit/delete/${book.id}">Delete</a> ]
			<br>
		</c:forEach>
	
	
	
</body>
</html>