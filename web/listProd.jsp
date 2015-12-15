<%@page import="com.magasin.entities.Produit"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    

<head>    
    <title>produit du magasin Louis-Etienne Online</title>
    <% List <Produit> lp = (List<Produit>)session.getAttribute("listeP"); %>
</html>
<body><%
        if (request.getAttribute("message")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
        %>

<h1>Liste des produits</h1>
<div>
    <table>
        <tr>
            <th>Code barre</th>
            <th>Nom du produit</th>
            <th>Cat&eacute;gorie</th>
            <th>Prix</th>
            <th>Quantit&eacute;</th>
            <th>Quantité d'ajout?</th>
            <th>ajouter au panier</th>
        </tr>
        <% for(int i=0; i<lp.size(); i++){

        %>
        
        <tr>
            <form post="" action="ajoutProd.do" >
                <th><%= lp.get(i).getCodeBarre() %></th>
                <th><%= lp.get(i).getNom() %></th> 
                <th><%= lp.get(i).getCategorie() %></th>
                <th><%= lp.get(i).getPrix() %></th>
                <th><%= lp.get(i).getQuantite() %> </th>
                <th><input name="qteProd"type='number' min='1' max='<%= lp.get(i).getQuantite() %>'></input> </th>
                <th><input name=""type='submit' value="ajouter"></input> </th>
                <!-- <th><a href=add.do?action=ajouterPanier&codeProduit=<% /*=lp.get(i).getCodeProduit()*/ %>&qteProd=>ajouter</a></th> -->
                <!--<th><a href=mod.do?action=modProd&codeProduit=<%/*=lp.get(i).getCodeProduit()*/ %> >modifier</a></th> -->
                <input type="hidden" name="action" value="ajouterPanier" >
                <input type="hidden" name="codeProduit" value="<%= lp.get(i).getCodeProduit() %>" >       
            </form>
        </tr>
        
        <% }%>

    </table>
</div>

</body>
</html>