<%-- 
    Document   : choose
    Created on : Jun 4, 2018, 11:56:22 AM
    Author     : sunling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Choose</title>
    </head>
    <body>
        <form method='post' action='ChooseServlet'>
            <p>Is JSP cool?</p>
            <input type='radio' value='1' name='radioJSPCool' ${stateJSP.yesCheck}><span>Yes</span><br/>
            <input type='radio' value='0' name='radioJSPCool' ${stateJSP.noCheck}><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <p>Is JSF way cool?</p>
            <input type='radio' value='1' name='JSFwayCool' ${stateJSF.yesCheck}><span>Yes</span><br/>
            <input type='radio' value='0' name='JSFwayCool' ${stateJSF.noCheck}><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <p>Is the moon made of cheese?</p>
            <input type='radio' value='1' name='moonCheese' ${stateMoon.yesCheck}><span>Yes</span><br/>
            <input type='radio' value='0' name='moonCheese' ${stateMoon.noCheck}><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
        </form>
    </body>
</html>
