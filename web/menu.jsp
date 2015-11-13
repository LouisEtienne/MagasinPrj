<%-- 
    Document   : menu
    Created on : Nov 8, 2015, 9:08:02 PM
    Author     : Marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <%
        boolean admin = false;
        if (session.getAttribute("connecte")== "1234") //le code de l'admin  //a faire verifier creation compte = code admin
            admin = true;
    %>

    </head>
    <body>
        <% if(admin == false){%>
            <ul>
                <li>
                        <a href="index.html">Accueil</a>
                </li>
                <li>
                        <a href="ctrl.do?action=PlisteL">Voir Panier</a>
                </li>
                <li>
                        <a href="ctrl.do?action=PlisteC">Voir liste?</a>
                </li>                                
                <li>
                        <a href=".do">Modifier compte</a>
                </li>
                <li>
                        <a href="ctrl.do?action=">Se déconnecter</a>
                </li>	
            </ul>
            <%} if(admin == true){%>
            <ul>
                <li>
                        <a href=".dol">Accueil</a>
                </li>
                <li>
                        <a href=".do">ajouterr produit</a>
                </li>
                <li>
                        <a href=".do">/modifie produit</a>
                </li>
                <li>
                        <a href="ctrl.do?action=">Se déconnecter</a>
                </li>	
            </ul>
        <%}%>
    </body>
</html>
