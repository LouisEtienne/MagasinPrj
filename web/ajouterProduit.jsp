<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Produit</title>
</head>
<body>

	<h1>Ajouter Produit</h1>
        <%
        if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
        %>
        <form action="ajouterProd.do">
            code du produit (4lettres 6chiffre) : <input name="codeP" type="text" pattern=".{10,10}" 
                required title="10 caractères" value="<%=(request.getParameter("codeP")==null)?"":request.getParameter("codeP")%>"><br><br>
            code barre du produit : <input name="codeBarreP" type="text" pattern=".{12,13}" 
                                             required title="12 a 13 caractères" value="<%=(request.getParameter("codeBarreP")==null)?"":request.getParameter("codeBarreP")%>"><br><br>
            nom du produit : <input name="nomP" type="text" 
            required ><br><br>
            prix : <input name="prixP" type="number" min=0 step=0.1 required value="<%=(request.getParameter("prixP")==null)?"":request.getParameter("prixP")%>">  $<br><br>
            quantité : <input name="qteP" type="number" min=0 required value="<%=(request.getParameter("qteP")==null)?"":request.getParameter("qteP")%>"><br><br>
            description : <textarea placeholder="description du produit"></textarea><br><br>
            catégorie :<input type="text" name="categorie" value=""> </input>
            <br><br>
            <input type="hidden" name="action"></input><br />
            <input type="submit" value="ajouter"></input>
            <input type="sumbit" value="annuler"></input>
        </form>
</body>
</html>