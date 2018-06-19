<%-- 
    Document   : dict
    Created on : Jun 18, 2018, 2:18:53 PM
    Author     : sunling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Dictionary</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src ="js/dict.js"></script>
    </head>
    <body>
        <h1>WAP Online Dictionary</h1>
        
        <label id="lookuplable">
            Term:
            <input id="term" name="term" type="text"/>
            <button id="lookupBtn">
                Lookup
            </button>
        </label>
        <div id="result">
        </div>
        
    </body>
</html>
