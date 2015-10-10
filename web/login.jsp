<%-- 
    Document   : login
    Created on : 5-Oct-2015, 4:26:18 PM
    Author     : Louis-E
--%>

<%
    if (session.getAttribute("connecte")!=null)  //déjà connecté
    {
%>
        <jsp:forward page="index.jsp" />
<%
    }
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple de MVC</title>
        <style type="text/css">
            .errorMessage {color : red;}
        </style>
    </head>
    <body>
<%
        if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
        String  us1 = request.getParameter("username");
        if (us1==null) us1="";
        else us1 = us1.trim();
        %>
        <form action="login.do" method="post">
            Username : <input type="text" name="username" value="<%=us1%>" /><br />
            Password : <input type="password" name="password" />
            <input type="hidden" name="action" value="login" /><br />
            <input type="submit" value=" Connexion " />
        </form>    
    </body>
</html>

