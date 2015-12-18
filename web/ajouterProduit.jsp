<%@page import="java.util.LinkedList"%>
<%@page import="com.magasin.entities.Produit"%>
<%@page import="java.util.List"%>
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
        List<String> listeCategories = new LinkedList<String>();
        listeCategories = (List<String>) request.getAttribute("listeCategories");
        %>
        <form action="ajouterProd.do">
            <label>Code du produit (4 lettres 6 chiffres) : </label><input name="codeP" type="text" pattern=".{10,10}" 
                required title="10 caractères" value="<%=(request.getParameter("codeP")==null)?"":request.getParameter("codeP")%>"><br /><br />
            <label>Code barre du produit : </label><input name="codeBarreP" type="text" pattern=".{12,13}" 
                                             required title="12 a 13 caractères" value="<%=(request.getParameter("codeBarreP")==null)?"":request.getParameter("codeBarreP")%>"><br /><br />
            <label>Nom du produit : </label><input name="nomP" type="text" required value="<%=(request.getParameter("nomP")==null)?"":request.getParameter("nomP")%>"/><br /><br />
            <label>Prix : </label><input name="prixP" type="number" min=0 step=0.01 required value="<%=(request.getParameter("prixP")==null)?"":request.getParameter("prixP")%>"><label> $</label><br /><br />
            <label>Quantit&eacute; : </label><input name="qteP" type="number" min=0 required value="<%=(request.getParameter("qteP")==null)?"":request.getParameter("qteP")%>"><br /><br />
            <label>Cat&eacute;gorie :</label><input type="text" name="catP" value="<%=(request.getParameter("catP")==null)?"":request.getParameter("catP")%>"> </input>
            <select name="categorie">
            <option value="nouvelleCategorie">--Nouvelle categories--</option>
            
            <%
            if(listeCategories.size()>0){
            for(int i = 0; i < listeCategories.size(); i++)
            {
                %>
                <option value="<%=listeCategories.get(i)%>">
                    <%=listeCategories.get(i)%>
                </option>
                <%
            }
            }
            
            %>
            </select>
            <br /><br />
            <input type="hidden" name="action" value="ajouterProd" /><br />
            <input type="submit" class="bouton" value="Ajouter"></input>
            <input type="reset" class="bouton" value="Effacer les champs"></input>
        </form>
    </body>
</html>