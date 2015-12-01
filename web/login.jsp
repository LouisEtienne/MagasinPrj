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
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="connexion">
            <div id="entete">
                <h1>Cr&eacute;ation d'un compte sur le magasin de Louis-&Eacute;tienne inc.</h1>
            </div>         
            <h1>Connexion sur le magasin de Louis-&Eacute;tienne inc.</h1>
            <div id="formConnexionAcheteur">
                <%
                    if (request.getAttribute("message")!=null)
                    {
                        out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
                    }
                    String  us1 = request.getParameter("username");
                    if (us1==null) us1="";
                        else us1 = us1.trim();
                %>
        
                <form action="login.do" >
                    <h3>Client</h3>
                    <label>Adresse courriel : </label><input type="text" name="user" value="">
                    <br /><br />
                    <label>Mot de passe : </label><input type="password" name="pass" value="">
                    <br /><br />                               
                    <input type="hidden" name="action" value="loginAcheteur" />
                    <input type="image" value=submit src="images/boutonEnvoyer.jpg" />
                    <br />
                    <a href="create.do?action=creerCompte">Cr&eacute;er un Compte</a>                
                    <br />
                </form>      
            </div>
        
            <hr>
            <div id="formConnexionAdmin">
                <%
                    if (request.getAttribute("messageAdmin")!=null)
                    {
                        out.println("<span class=\"errorMessage\">"+request.getAttribute("messageAdmin")+"</span>");
                    }
                %>
                <form action="ctrl.do" >
                    <h3>Administrateur</h3>
                    <label>Code administrateur : </label><input type="text" name="user" value="">
                    <br /><br />
                    <label>Mot de passe : </label><input type="password" name="pass" value="">
                    <br />
                    <input type="hidden" name="action" value="loginAdmin" /><br />
                    <input type="image" value=submit src="images/boutonEnvoyer.jpg" />
                </form>
            </div>
        </div>
    </body>
</html>

