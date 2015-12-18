<%-- 
    Document   : modifierCompteAdmin
    Created on : 2015-12-01, 17:49:13
    Author     : Kismony Ladouceur
    Modifié par : Michel Plamondon
    Cette page sert pour l'administrateur du site à modifier les informations
    personnelles d'un compte acheteur.
--%>

<%@page import="com.magasin.entities.Acheteur"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'un compte acheteur</title>
    </head>
    <body>
        <h2>Modification d'un profil acheteur</h2>
        <%
        Acheteur unAcheteur = (Acheteur)(request.getAttribute("unAcheteur"));
        if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
        if(unAcheteur != null) {
        %>
        <form method="POST" action="modifierCompteAdmin.do">
            <label>Courriel *: </label><input type="text" name="courriel" value="<%= unAcheteur.getCourriel() %>" readonly ><br>
            <label>Mot de passe *: </label><input type="password" name="motdepasse" value="<%= unAcheteur.getMotPasseAcheteur() %>" required><br>
            <label>Confirmer mot de passe *: </label><input type="password" name="motdepasseconfirme" value="<%= unAcheteur.getMotPasseAcheteur() %>" required><br>
            <label>Nom*: </label><input type="text" name="nom" value="<%= unAcheteur.getMotPasseAcheteur() %>" required=""><br>
            <label>Pr&eacute;nom *: </label><input type="text" name="prenom" value="<%= unAcheteur.getPrenomAcheteur() %>" required><br>
            <label>Adresse *: </label><input type="text" name="adresse" value="<%= unAcheteur.getAdresse() %>"><br>
            <label>T&eacute;l&eacute;phone *: </label><input type="text" name="telephoneprincipal" value="<%= unAcheteur.getTelephonePrincipal() %>"><br>
            <label>T&eacute;l&eacute;phone secondaire: </label><input type="text" name="telephonesecondaire" value="<%= unAcheteur.getTelephoneSecondaire() %>"><br>
            <label>Ville *: </label><input type="text" name="ville" value="<%= unAcheteur.getVille() %>"><br>
            <label>Province *: </label><input type="text" name="province" value="<%= unAcheteur.getProvince() %>"><br>
            <label>Code postal *: </label><input type="text" name="codepostal" value="<%= unAcheteur.getCodePostal() %>"><br>
            <label>Num&eacute;ro de carte de cr&eacute;dit *: </label><input type="password" name="numero" value="<%= unAcheteur.getNoCarteCredit() %>"><br>
            <%
                if(unAcheteur.isCompteActif() == 1) {                
            %>
                    <label><input type="radio" name="etat" value="actif" checked="checked" />Actif</label><br />
                    <label><input type="radio" name="etat" value="inactif"/>Inactif</label><br />              
            <%
                }
                else {    
            %>
                    <label><input type="radio" name="etat" value="actif" />Actif</label><br />
                    <label><input type="radio" name="etat" value="inactif" checked="checked" />Inactif</label><br />               
            <%
                }
            %>
            <h4>* obligatoire</h4>
        <%        
        }
        %>
            <input type="hidden" name="action" value="modifierCompteAdmin">
            <input type="submit" name="" class="bouton" value="Modifier">
        </form>          
        <%
        if (request.getAttribute("messageModificationAcheteur")!=null)
        {
             out.println("<p class=\"errorMessage\">"+request.getAttribute("messageModificationAcheteur")+"</p>");
        }
        %>        
    </body>
</html>
