<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Task 6</title>
</head>
<body style="margin: 0px;font-family: arial; line-height: 1.6;">

<table height=50px width=100% cellpadding=10px cellspacing=0 
style="margin-bottom: 20px; border-bottom: 2px #888888 solid; background: #dddddd;"><tr>
<td style="font-size: 28px; ">
Index page
</td>
<td align=right>
User 
&nbsp;&nbsp;&nbsp;
<a href="">Exit</a>
&nbsp;&nbsp;&nbsp;
</td>
</tr></table>
 
 <table cellpadding=10  style="font-family: arial; line-height: 1.6; "><tr>
 <td style="vertical-align: top">
 <h2>Books</h2>
 
 <a href="/sp-cources/book/edit/insert/-1">Insert book</a><br><br>
		<c:forEach var="book" items="${books}" varStatus="loop">
			${loop.index+1}. <b>«${book.name}»</b> by ${book.author.firstName} ${book.author.lastName}, publ. in ${book.publishedIn}
			&nbsp; &nbsp; [ <a href="/sp-cources/book/edit/update/${book.id}">Update</a>
			&nbsp; <a href="/sp-cources/book/edit/delete/${book.id}">Delete</a> ]
			<br>
		</c:forEach>
	
	
 </td>
 <td style="vertical-align: top; padding-left: 60px;">
 <h2>Authors</h2>
 
 <a href="/sp-cources/author/edit/insert/-1">Insert author</a><br><br>
		<c:forEach var="author" items="${authors}" varStatus="loop">
			${loop.index+1}. <b>${author.firstName} ${author.lastName}</b>, born ${author.dateOfBirth}
			&nbsp; &nbsp; [ <a href="/sp-cources/author/edit/update/${author.id}">Update</a>
			&nbsp; <a href="/sp-cources/author/edit/delete/${author.id}">Delete</a> ]
			<br>
		</c:forEach>
	
	<br>&nbsp;<br>
	<h2>Users</h2>
	<a href="/sp-cources/user/edit/insert/-1">Insert user</a><br><br>
	
		<c:forEach var="user" items="${users}" varStatus="loop">
			${loop.index+1}. <b>${user.name}</b>, role: ${user.role}
			&nbsp; &nbsp; [ <a href="/sp-cources/user/edit/update/${user.id}">Update</a>
			&nbsp; <a href="/sp-cources/user/edit/delete/${user.id}">Delete</a> ]
			<br>
		</c:forEach>
		
	
 </td>
 </tr></table>
	
	
</body>
</html>