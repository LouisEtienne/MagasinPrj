<!DOCTYPE html>
<html>
    <head>
        <title>Ajouter produit</title>
    </head>
    <body>
	<h2>Ajouter produit</h2>
        <%
        if (request.getAttribute("messageCreation")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("messageCreation")+"</span>");
        }
        %>
        <form action="ajouterProd.do">
            <label>Code du produit (4 lettres 6 chiffres) : </label><input name="codeP" type="text" pattern=".{10,10}" 
                required title="10 caractères" value="<%=(request.getParameter("codeP")==null)?"":request.getParameter("codeP")%>"><br /><br />
            <label>Code barre du produit : </label><input name="codeBarreP" type="text" pattern=".{12,13}" 
                                             required title="12 a 13 caractères" value="<%=(request.getParameter("codeBarreP")==null)?"":request.getParameter("codeBarreP")%>"><br /><br />
            <label>Nom du produit : </label><input name="nomP" type="text" required /><br /><br />
            <label>Prix : </label><input name="prixP" type="number" min=0 step=0.1 required value="<%=(request.getParameter("prixP")==null)?"":request.getParameter("prixP")%>"><label> $</label><br /><br />
            <label>Quantit&eacute; : </label><input name="qteP" type="number" min=0 required value="<%=(request.getParameter("qteP")==null)?"":request.getParameter("qteP")%>"><br /><br />
            <label>Description : </label><textarea placeholder="description du produit"></textarea><br><br>
            <label>Cat&eacute;gorie :</label><input type="text" name="categorie" value=""> </input>
            <br /><br />
            <input type="image" src="images/boutonAjouter.jpg">
            <input type="hidden" name="action" value="ajouterProd" /><br />
            <input type="submit" value="ajouter"></input>
            <input type="submit" value="annuler"></input>
        </form>
    </body>
</html>