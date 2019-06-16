<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Hello!!</title>
<h3> <a href="/sp-cources/logout"> Logout</a>
</head>
<body>

			<h2>Welcome : ${pageContext.request.userPrincipal.name}


		</h2>
<hr type="disc">
<hr>
<li> <A href="/sp-cources/book/add">Добавить</a> </li>
<li> <A href="/sp-cources/book/delete"> Удалить</A> </li>
<li> <A href="/sp-cources/book/redit">Редактировать</A></li>
<li> <A href="/sp-cources/book/find">Найти</A></li>
<li> <A href="/sp-cources/book/list">Список книг</A></li>
</ul>
</body>
</html>