<%-- 
    Document   : supprimerProduit
    Created on : 2015-11-27, 11:00:53
    Author     : Michel Plamondon
--%>

<%@page import="com.magasin.entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supprimer un produit</title>
    </head>
    <body>
        <h2>Supprimer un produit</h2>
        <%
            
            Produit unProduit = (Produit)(request.getAttribute("unProduit"));
        %>
        <table>
            <label>Code produit : </label><%= unProduit.getCodeProduit() %><br /><br />
            <label>Nom du produit : </label><%= unProduit.getNom() %><br /><br />
            <label>Code barre du produit : </label><%= unProduit.getCodeBarre() %><br /><br />
            <label>Cat&eacute;gorie : </label><%= unProduit.getCategorie() %><br /><br />
            <label>Prix : </label><%= unProduit.getPrix() %><br /><br />
            <label>Quantit&eacute; : </label><%= unProduit.getQuantite() %><br /><br />
        </table>
        <form  method="POST" action="supProd.do">
            <input type="hidden" name="codeP" value="<%= unProduit.getCodeProduit() %>" >
            <input type="image" src="images/boutonSupprimer.jpg" />
            <input name="action" value="supProd" type="hidden" />        
        </form>
    </body>
</html>
