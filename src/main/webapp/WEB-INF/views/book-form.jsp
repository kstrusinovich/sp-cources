<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    </head>
    <body style="font-family: arial; line-height: 1.6;">
        <h2 style="color: red;">${errorMessage}</h2>
        <h3>${mode} book</h3>
        
        <form:form method="POST" action="/sp-cources/book/edit/${mode}" modelAttribute="book">
        
        <form:input path="id" type="hidden" />
        
        
             <table cellpadding=5>
               
               
                <tr>
                    <td><form:label path="name" >Name:</form:label></td>
                    <td><form:input path="name" style="font-size: 16px;font-family: arial; "/></td>
                </tr>
                <tr>
                    <td><form:label path="publishedIn">Published in:</form:label></td>
                    <td><form:input path="publishedIn" style="font-size: 16px;font-family: arial; "/></td>
                </tr>
                 <tr>
                    <td><form:label path="author.id">Author:</form:label></td>
                    <td>
                    <form:select path="author.id"  style="font-size: 16px;font-family: arial; ">
                    <c:forEach items="${authors }" var="aut">
                    <option value="${aut.id }" 
                    <c:if test="${aut.id== book.author.id}">selected</c:if> >${aut.firstName } ${aut.lastName }</option> 
                    </c:forEach>
                    
                    </form:select>
                    
                    </td>
                </tr>
                <!-- 
                <tr>
                    <td><form:label path="author.firstName">Author first name:</form:label></td>
                    <td><form:input path="author.firstName" style="font-size: 16px;font-family: arial; "/></td>
                </tr>
                <tr>
                    <td><form:label path="author.lastName">Author last name:</form:label></td>
                    <td><form:input path="author.lastName" style="font-size: 16px;font-family: arial; "/></td>
                </tr>
                 
                <tr>
                 
                    <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
                
                    <td><form:label path="author.dateOfBirth">Author date of birth:</form:label></td>
                    <td><form:input path="author.dateOfBirth" type="date" style="font-size: 16px;font-family: arial; "/></td>
                </tr>
                 -->
                <tr>
                    <td style="padding-top: 20px;"><input type="submit"  style="font-size: 20px;font-family: arial; " value="${mode}"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>