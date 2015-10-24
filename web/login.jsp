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
        <title>Connexion</title>
        <style type="text/css">
            .errorMessage {color : red;}
            body {background-color:lightgray}
            #form {width : 50%}
            #form {background-color:orange}
            #form {border-style: solid}
        </style>
        
    </head>
    <body>
        <h1>Connexion</h1>
        <%
        if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
        String  us1 = request.getParameter("username");
        if (us1==null) us1="";
        else us1 = us1.trim();
        %>
        <div id="form">
	<form action="login.do">
		<h3>Administrateur</h3>
		code Administrateur: <input type="text" name="firstname">
		<br><br>
		Mot de passe:	<input type="password" name="lastname">
		<br><br>
		<hr><h3>Client</h3>
		Adresse Email: <input type="text" name="firstname">
		<br><br>
		Mot de passe:	<input type="password" name="lastname">
		<br><br>
                <input type="hidden" name="action" value="login" /><br />
		<input type="submit" value="Submit">
		<br><br>
	</form>
</div>
    </body>
</html>

