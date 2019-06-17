<%--
  Created by IntelliJ IDEA.
  User: Rusinovich
  Date: 17.06.2019
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/style/style.css"%>
    </style>
</head>
<body>
<h1>Welcome!</h1>

<div id="mainmenu">
    <ul>
        <li><a href="/sp-cources/book/add/">Insert new</a></li>
        <li><a href="/sp-cources/book/list/">List books</a></li>
        
        <li><a href="/sp-cources/book/find">Find</a></li>
        <li><a href="/sp-cources/logout">Logout</a></li>
    </ul>
</div>
</body>
</html>
