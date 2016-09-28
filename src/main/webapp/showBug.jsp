<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bug</title>
    </head>
    <body>
        <p>
            Chosen bug: <%= request.getParameter("bug")%>
        </p>
    </body>
</html>
