<!DOCTYPE html>
<html>
    <head>
        <title>Cr&eacute;er Compte</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="entete">
            <h1>Cr&eacute;ation d'un compte sur le magasin de Louis-&Eacute;tienne inc.</h1>
        </div>
        <div id="creationCompte">        
            <h2>Cr&eacute;ation d'un compte</h2>        
            <%
            if (request.getAttribute("message")!=null)
            {
                out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
            }
            %>
            <form action="creerCpt.do">
                <label>Courriel *: </label><input type="text" name="courr" value="<%=(request.getParameter("courr")==null)?"":request.getParameter("courr")%>" value="abc4321"><br />	
                <label>Mot de passe *: </label><input type="password" name="pass" value="" value="abc4321"><br />
                <label>Confirmer mot de passe *: </label><input type="password" name="passConf" value=""  value="abc4321"><br />
                <label>Nom*: </label><input type="text" name="nom" value="<%=(request.getParameter("nom")==null)?"":request.getParameter("nom")%>"><br />
                <label>Pr&eacute;nom *: </label><input type="text" name="pren" value="<%=(request.getParameter("pren")==null)?"":request.getParameter("pren")%>"><br />
                <label>Adresse *: </label><input type="text" name="adre" value="<%=(request.getParameter("adre")==null)?"":request.getParameter("adre")%>"><br />
                <label>T&eacute;l&eacute;phone *: </label><input type="text" name="phone" value="<%=(request.getParameter("phone")==null)?"":request.getParameter("phone")%>"><br />
                <label>T&eacute;l&eacute;phone secondaire: </label><input type="text" name="phone2" value="<%=(request.getParameter("phone")==null)?"":request.getParameter("phone")%>"><br />
                <label>Ville *: </label><input type="text" name="ville" value="<%=(request.getParameter("ville")==null)?"":request.getParameter("ville")%>"><br />
                <label>Province *: </label><input type="text" name="pro" value="<%=(request.getParameter("pro")==null)?"":request.getParameter("pro")%>"><br />
                <label>Code postal *: </label><input type="text" name="cPos" value="<%=(request.getParameter("cPos")==null)?"":request.getParameter("cPos")%>"><br />
                <label>Num&eacute;ro de carte de cr&eacute;dit *: </label><input type="text" name="cred" value="<%=(request.getParameter("cred")==null)?"":request.getParameter("cred")%>"><br />
                <h4>* obligatoire</h4><br />
                <input type="submit" class="bouton" name="action" value="Cr&eacute;er le compte">
            </form>
            <br />
            <form action="12435.do">
                <input type="hidden" name="action" value="loginAcheteur">
                <input type="submit" name="" class="bouton" value="Annuler">
            </form>
        </div>
    </body>
</html>