<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    </head>
    <body style="font-family: arial; line-height: 1.6;">
        <h2 style="color: red;">${errorMessage}</h2>
        <h3>${mode} author</h3>
        
        <form:form method="POST" action="/sp-cources/author/edit/${mode}" modelAttribute="author">
        
        <form:input path="id" type="hidden" />
        
        
             <table cellpadding=5>
               
               
               
                <tr>
                    <td><form:label path="firstName">First name:</form:label></td>
                    <td><form:input path="firstName" style="font-size: 16px;font-family: arial; "/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last name:</form:label></td>
                    <td><form:input path="lastName" style="font-size: 16px;font-family: arial; "/></td>
                </tr>
                 
                <tr>
                                    
                
                    <td><form:label path="dateOfBirth">Date of birth:</form:label></td>
                    <td><form:input path="dateOfBirth" type="date" style="font-size: 16px;font-family: arial; "/>
                    <br><form:errors path="dateOfBirth" cssClass="error" />
                    </td>
                </tr>
                 
                <tr>
                    <td style="padding-top: 20px;"><input type="submit"  style="font-size: 20px;font-family: arial; " value="${mode}"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>