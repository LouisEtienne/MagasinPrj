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

<h1>Modification d'un compte</h1>
    <div>
        
        <form method="POST" action="ctrl.do">
            courriel *: <input type="text" name="courriel" value="<%=(((Acheteur)request.getSession().getAttribute("acheteur")).getCourriel())%>" readonly ><br>
            mot de passe *: <input type="password" name="motdepasse" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getMotPasseAcheteur())%>" required><br>
            Confirmer mot de passe *: <input type="password" name="motdepasseconfirme" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getMotPasseAcheteur())%>" required><br>
            nom*: <input type="text" name="nom" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getNomAcheteur())%>" required=""><br>
            Prénom *: <input type="text" name="prenom" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getPrenomAcheteur())%>" required><br>
            adresse: <input type="text" name="adresse" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getAdresse())%>"><br>
            téléphone: <input type="text" name="telephoneprincipal" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getTelephonePrincipal())%>"><br>
            téléphone secondaire: <input type="text" name="telephonesecondaire" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getTelephoneSecondaire())%>"><br>
            Ville: <input type="text" name="ville" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getVille())%>"><br>
            Province: <input type="text" name="province" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getProvince())%>"><br>
            Code postal: <input type="text" name="codepostal" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getCodePostal())%>"><br>
            numéro de carte de crédit : <input type="text" name="numero" value="<%=(((Acheteur) request.getSession().getAttribute("acheteur")).getNoCarteCredit())%>"><br>
            
                                <!--Actif/Non actif(pour compte admin)
                                
                                <label><input type="radio" name="etat" value="actif" /> Actif</label><br />
                                <label><input type="radio" name="etat" value="inactif" checked="checked" /> Inactif</label><br />
                                 -->     
            <h4 style="color : red">* obligatoire</h4>
            
            <input type="hidden" name="action" value="compteModifie">
            <input type="submit" name="" value="Modifier">
        </form>
        <form>
            <input type="hidden" name="action" value="annulation">
            <input type="submit" name="" value="annuler">
        </form>
    </div>


</body>
</html>