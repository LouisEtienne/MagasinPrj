<%@page import="com.magasin.entities.Produit"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    

<head>    
    <title>produit du magasin Louis-Etienne Online</title>
    <% List <Produit> lp = (List<Produit>)session.getAttribute("listeP"); %>
</html>
<body>

<h1>Liste des produits</h1>
<div>
    <table>
        <tr>
            <th>Code barre</th>
            <th>Nom du produit</th>
            <th>Cat&eacute;gorie</th>
            <th>Prix</th>
            <th>Quantit&eacute;</th>
<!--            <th>Retirer</th>-->
            <th>ajouter au panier</th>
        </tr>
        <% for(int i=0; i<lp.size(); i++){

        %>
        <tr>
            <th><%= lp.get(i).getCodeBarre() %></th>
            <th><%= lp.get(i).getNom() %></th> 
            <th><%= lp.get(i).getCategorie() %></th>
            <th><%= lp.get(i).getPrix() %></th>
            <th><%= lp.get(i).getQuantite() %> </th>
            <th><a href=add.do?action=NOMACTION&codeProduit=<%=lp.get(i).getCodeProduit()%> >ajouter</a></th>
            <!--<th><a href=mod.do?action=modProd&codeProduit=<%/*=lp.get(i).getCodeProduit()*/ %> >modifier</a></th> -->
        </tr>
        <% }%>

    </table>
</div>

</body>
</html>