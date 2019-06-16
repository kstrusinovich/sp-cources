<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    </head>
    <body style="font-family: arial; line-height: 1.6;">
    
    <a href="/sp-cources"><< Index page</a>
    
    
        <h2 style="color: red;">${errorMessage}</h2>
        <h3>${mode} user</h3>
        
        <form:form method="POST" action="/sp-cources/user/edit/${mode}" modelAttribute="user">
        
        <form:input path="id" type="hidden" />
        
        
             <table cellpadding=5>
               
               
               
                <tr>
                    <td><form:label path="username">Username:</form:label></td>
                    <td><form:input path="username" style="font-size: 16px;font-family: arial; "/></td>
                    <td><form:errors path="username" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password:</form:label></td>
                    <td><form:input path="password" style="font-size: 16px;font-family: arial; "/></td>
                    <td><form:errors path="password" cssClass="error" /></td>
                </tr>
                 
                <tr>
                                    
                
                    <td><form:label path="role">Role:</form:label></td>
                    <td><form:input path="role" style="font-size: 16px;font-family: arial; "/></td>
                    <br><form:errors path="role" cssClass="error" />
                    </td>
                </tr>
                 
                <tr>
                    <td style="padding-top: 20px;"><input type="submit"  style="font-size: 20px;font-family: arial; " value="${mode}"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>