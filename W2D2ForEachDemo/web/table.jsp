<%-- 
    Document   : table
    Created on : Jun 5, 2018, 11:24:12 AM
    Author     : sunling
--%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ForEach DEMO</title>
    </head>
    <body>
        <table>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
