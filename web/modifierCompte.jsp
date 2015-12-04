<%@page import="com.magasin.entities.Acheteur"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page 
language="java"
%>
<%
    if (session.getAttribute("connecte") == null) //pas connecté
    {
%>
<jsp:forward page="login.jsp" />
<%
    } 
    
%>
<!DOCTYPE html>
<html>
<head>
<title>Modifier Compte</title>
</head>
<body>

<h2>Modification d'un compte</h2>
    <div>
        <form method="POST" action="ctrl.do">
            <label>Courriel *: </label><input type="text" name="courriel" value="<%=(((Acheteur)request.getSession().getAttribute("acheteur")).getCourriel())%>" readonly ><br>
            <label>Mot de passe *: </label><input type="password" name="motdepasse" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getMotPasseAcheteur())%>" required><br>
            <label>Confirmer mot de passe *: </label><input type="password" name="motdepasseconfirme" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getMotPasseAcheteur())%>" required><br>
            <label>Nom*: </label><input type="text" name="nom" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getNomAcheteur())%>" required=""><br>
            <label>Pr&eacute;nom *: </label><input type="text" name="prenom" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getPrenomAcheteur())%>" required><br>
            <label>Adresse *: </label><input type="text" name="adresse" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getAdresse())%>"><br>
            <label>T&eacute;l&eacute;phone *: </label><input type="text" name="telephoneprincipal" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getTelephonePrincipal())%>"><br>
            <label>T&eacute;l&eacute;phone secondaire: </label><input type="text" name="telephonesecondaire" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getTelephoneSecondaire())%>"><br>
            <label>Ville *: </label><input type="text" name="ville" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getVille())%>"><br>
            <label>Province *: </label><input type="text" name="province" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getProvince())%>"><br>
            <label>Code postal *: </label><input type="text" name="codepostal" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getCodePostal())%>"><br>
            <label>Num&eacute;ro de carte de cr&eacute;dit *: </label><input type="text" name="numero" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getNoCarteCredit())%>"><br>
            
                                <!--Actif/Non actif(pour compte admin)
                                
                                <label><input type="radio" name="etat" value="actif" /> Actif</label><br />
                                <label><input type="radio" name="etat" value="inactif" checked="checked" /> Inactif</label><br />
                                 -->     
            <h4>* obligatoire</h4>
            
            <input type="hidden" name="action" value="compteModifie">
            <input type="submit" name="" class="bouton" value="Modifier">
        </form>
        <br />
        <form>
            <input type="hidden" name="reset" value="effacer les champs">
            <input type="submit" name="" class="bouton" value="Annuler">
        </form>
        <%
        if (request.getAttribute("message")!=null)
        {
             out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
        %>
    </div>
</body>
</html>