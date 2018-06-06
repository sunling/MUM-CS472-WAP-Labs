<%-- 
    Document   : index
    Created on : Jun 1, 2018, 4:58:42 PM
    Author     : sunling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="advanceCal.do" method="POST">
                <p>
                     
                    <input type="number" name="num1" value="<%= request.getParameter("num1") %>"/> +
                    <input type="number" name="num2" value="<%= request.getParameter("num2") %>"/> = 
                    <input type="number" name="result1" value=${result1} /> 
                </p>

                <p>
                    <input type="number" name="num3" value="<%= request.getParameter("num3") %>"/> *
                    <input type="number" name="num4" value="<%= request.getParameter("num4") %>"/> =
                    <input type="number" name="result2" value=${result2} /> 
                </p>
                <p>
                    <input type="submit" value="submit" />  
                </p>
            </form>
        </div>
    </body>
</html>
