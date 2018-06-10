<%-- 
    Document   : quiz
    Created on : Jun 4, 2018, 1:43:45 PM
    Author     : sunling
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Version of the Quiz Servlet Lab</title>
        <script>
            function clickTest(hint){
                alert(hint);
            }
        </script>
    </head>
    
    <body>
        <h1>Have fun with NumberQuiz!</h1>
        <form action="quiz.do" method="POST">
            <p>
                Your age:<input type="number" name="age" value="${age}"/>
                <span style="color: red">${errorMsg}</span>
            </p>
            
            <p>Your current score is ${score}.</p>
            
            <p>Attempt ${attempts} / 3</p>
            
            <p>Guess the next number in the sequence!</p>
            
            <p> [${currQ},<span style="color: red;font-weight: bold">?</span>]</p>
       
            <p>Your answer:<input type='text' name='guess' value="${answer}"/></p>
            
            <input type='submit' value="next" />
        </form>
            
        <form action="quiz.do">
            <input type ="hidden" name="opt" value="STARTOVER"/>
            <input type='submit' value="Restart!" />
        </form>
            
        <p><span style="color: red">${tryMsg}</span></p>
        <p><input type="button" value="hint?" onclick="clickTest('${currH}')" /></p>
    </body>
</html>
