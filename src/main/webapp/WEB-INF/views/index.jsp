<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Task 6</title>
</head>
<body style="font-family: arial; line-height: 1.6;">

	
<!-- 
	<p><b>Just list:</b><p>
<pre>
	${books}
</pre>
 -->
 <!-- 
	<p><b>Iterated List:</b><p>
 -->
 
 <table  style="font-family: arial; line-height: 1.6; "><tr>
 <td style="vertical-align: top">
 <h2>Books</h2>
 
 <a href="/sp-cources/book/edit/insert/-1">Insert new book</a><br><br>
		<c:forEach var="book" items="${books}" varStatus="loop">
			${loop.index+1}. <b>«${book.name}»</b> by ${book.author.firstName} ${book.author.lastName}, publ. in ${book.publishedIn}
			&nbsp; &nbsp; [ <a href="/sp-cources/book/edit/update/${book.id}">Update</a>
			&nbsp; <a href="/sp-cources/book/edit/delete/${book.id}">Delete</a> ]
			<br>
		</c:forEach>
	
	
 </td>
 <td style="vertical-align: top; padding-left: 60px;">
 <h2>Authors</h2>
 
 <a href="/sp-cources/author/edit/insert/-1">Insert new author</a><br><br>
		<c:forEach var="author" items="${authors}" varStatus="loop">
			${loop.index+1}. <b>${author.firstName} ${author.lastName}</b>, born ${author.dateOfBirth}
			&nbsp; &nbsp; [ <a href="/sp-cources/author/edit/update/${author.id}">Update</a>
			&nbsp; <a href="/sp-cources/author/edit/delete/${author.id}">Delete</a> ]
			<br>
		</c:forEach>
	
	
 </td>
 </tr></table>
	
	
</body>
</html>