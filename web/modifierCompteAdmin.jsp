<%-- 
    Document   : modifierCompteAdmin
    Created on : 2015-12-01, 17:49:13
    Author     : MonOrdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'un compte acheteur</title>
    </head>
    <body>
        <h2>Modification d'un profil acheteur</h2>
        
        <%
        if (request.getAttribute("messageModificationAcheteur")!=null)
        {
             out.println("<p class=\"errorMessage\">"+request.getAttribute("messageModificationAcheteur")+"</p>");
        }
        %>        
    </body>
</html>
