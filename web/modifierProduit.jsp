<%-- 
    Document   : ModifierProduit
    Created on : Nov 19, 2015, 11:00:44 PM
    Author     : Marie
--%>

<%@page import="com.magasin.entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'un produit</title>
        <%
            Produit pr = (Produit)session.getAttribute("produit");
        %>
    </head>
    <body>
        <h2>Modifier un produit</h2>
        <%
        if (request.getAttribute("messageModification")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("messageModification")+"</span>");
        }
        %>        
        <form action="modProd.do">
            <table>
                <tr><td>Code barre</td> <td><%= pr.getCodeBarre() %></td><td><input name="codeBarreP" type="text" pattern=".{12,13}" required title="12 a 13 caractères" 
                    value="<%= pr.getCodeBarre() %>" ></td></tr>
                <tr><td>Nom produit</td><td><%= pr.getNom() %></td><td><input name="nomP" type="text" value="<%= pr.getNom() %>"
                    required ></td></tr>
                <tr><td>Cat&eacute;gorie</td><td><%= pr.getCategorie() %></td><td>            
                    <select name="catP" required>
                        <option>type 1</option>
                        <option>type 2</option>
                        <option>type 3</option>
                    </select></td></tr>
                <tr><td>Prix</td><td><%= pr.getPrix() %></td><td><input name="prixP" type="number" min=0 step=0.1 required value="<%= pr.getPrix() %>" ></td></tr>
                <tr><td>Quantit&eacute;</td><td><%= pr.getQuantite() %></td><td>
                    <input name="qteP" type="number" min=0 required value="<%= pr.getQuantite() %>" ></td></tr>
            </table>
            <input type="hidden" value="<%= pr.getCodeProduit() %>" name="codeP">        
            <input type="hidden" value="produitModifie" name="action">
            <input type="submit" class="bouton" value="Ajouter"></input>
            <input type="submit" class="bouton" value="Annuler"></input>
        </form>
        
    </body>
</html>
