<%-- 
    Document   : result.jsp
    Created on : Jun 4, 2018, 4:31:48 PM
    Author     : sunling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Over</title>
    </head>
    <body>
        <h1>Game Over</h1>
        <p>Your current score is ${score}.</p>
        <p>Your grade is</p>   
        <p style="color: red;font-weight: bold">${grade}</p>

        <p>
            <form action="quiz.do" method="POST">
                <input type ="hidden" name="opt" value="STARTOVER"/>
                <input type="submit" value="start over!"/>
            </form>
        </p>
</body>
</html>
