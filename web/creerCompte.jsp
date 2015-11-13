<!DOCTYPE html>
<html>
    <head>
    <title>Créer Compte</title>
        <style type="text/css">
            .errorMessage {color : red;}
            .resultat {font-weight: bold;}
        </style>
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
            courriel *: <input type="text" name="courr" value="<%=(request.getParameter("courr")==null)?"":request.getParameter("courr")%>" valuue="abc4321"><br>	
            mot de passe *: <input type="password" name="pass" value="" valuue="abc4321"><br>
            Confirmer mot de passe *: <input type="password" name="passConf" value=""  valuue="abc4321"><br>
            nom*: <input type="text" name="nom" value="<%=(request.getParameter("nom")==null)?"":request.getParameter("nom")%>" valuue="abc4321"><br>
            Prénom *: <input type="text" name="pren" value="<%=(request.getParameter("pren")==null)?"":request.getParameter("pren")%>" valuue="abc4321"><br>
            adresse: <input type="text" name="adre" value="<%=(request.getParameter("adre")==null)?"":request.getParameter("adre")%>" valuue="abc4321"><br>
            téléphone: <input type="text" name="phone" value="<%=(request.getParameter("phone")==null)?"":request.getParameter("phone")%>" valuue="abc4321"><br>
            téléphone secondaire: <input type="phone2" name="" value="<%=(request.getParameter("phone2")==null)?"":request.getParameter("phone2")%>" valuue="abc4321"><br>
            Ville: <input type="text" name="ville" value="<%=(request.getParameter("ville")==null)?"":request.getParameter("ville")%>" valuue="abc4321"><br>
            Province: <input type="text" name="pro" value="<%=(request.getParameter("pro")==null)?"":request.getParameter("pro")%>" valuue="abc4321"><br>
            Code postal: <input type="text" name="cPos" value="<%=(request.getParameter("cPos")==null)?"":request.getParameter("cPos")%>" valuue="abc4321"><br>
            numéro de carte de crédit : <input type="text" name="cred" value="<%=(request.getParameter("cred")==null)?"":request.getParameter("cred")%>" valuue="abc4321"><br>
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