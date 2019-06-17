<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<title>Hello</title>
<body>

<form:form method="POST" action="/sp-cources" modelAttribute="user">

	<h2><div align="center">Welcome,${user_name}!</div></h2>

	<li><div align="center"><a href="/sp-cources/logout">Logout</a></div></li>
	<li><div align="center"><a href="/sp-cources/book/list">list</a></div></li>
	<li><div align="center"><a href="/sp-cources/book/find">find</a></div></li>

</form:form>
</body>
</html>