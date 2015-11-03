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
            courriel *: <input type="text" name="courr"><br>	
            mot de passe *: <input type="password" name="pass"><br>
            Confirmer mot de passe *: <input type="passConf" name=""><br>
            nom*: <input type="text" name="nom"><br>
            Prénom *: <input type="text" name="pren"><br>
            adresse: <input type="text" name="adre"><br>
            téléphone: <input type="text" name="phone"><br>
            téléphone secondaire: <input type="phone2" name=""><br>
            Ville: <input type="text" name="ville"><br>
            Province: <input type="text" name="pro"><br>
            Code postal: <input type="text" name="cPos"><br>
            numéro de carte de crédit : <input type="text" name="cred"><br>
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