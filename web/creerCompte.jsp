<!DOCTYPE html>
<html>
<head>
<title>Créer Compte</title>
</head>
<body>

<h1>Création d'un compte</h1>
    <div>
        <%
        if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
        %>
        <form action="creerCpt.do">
            <!--type="email"-->
            courriel *: <input type="text" name="courr" value="abc"><br>	
            mot de passe *: <input type="password" name="pass" value="abc"><br>
            Confirmer mot de passe *: <input type="passConf" name=""value="abc"><br>
            nom*: <input type="text" name="nom"value="abc"><br>
            Prénom *: <input type="text" name="pren"value="abc"><br>
            adresse: <input type="text" name="adre"value="abc"><br>
            téléphone: <input type="text" name="phone"value="abc"><br>
            téléphone secondaire: <input type="phone2" name=""value="abc"><br>
            Ville: <input type="text" name="ville"value="abc"><br>
            Province: <input type="text" name="pro"value="abc"><br>
            Code postal: <input type="text" name="cPos"value="abc"><br>
            numéro de carte de crédit : <input type="text" name="cred"value="abc"><br>
            <h4 style="color : red">* obligatoire</h4>
            <input type="submit" name="action" value="compteCree">
        </form>
        <!--annuler -->
        <form action="12435.do">
            <input type="hidden" name="action" value="loginAcheteur">
            <input type="submit" name="" value="annuler">
        </form>
    </div>

</body>
</html>