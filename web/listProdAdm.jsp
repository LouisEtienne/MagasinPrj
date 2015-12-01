<%@page import="java.util.List"%>
<%@page import="com.magasin.entities.Produit"%>
<!DOCTYPE html>
<html>
<head>
<title>Liste de Produit</title>
<% List <Produit> lp = (List<Produit>)session.getAttribute("listeP"); %>

</head>
<body><%
        if (request.getAttribute("messageProduit")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("messageProduit")+"</p>");
        }
        %>
    <h1>Liste de Produits total:<%=lp.size()%></h1>
<table>
    <tr>
        <th>Code barre</th>
        <th>Nom produit</th>
        <th>catégorie</th>
        <th>Prix</th>
        <th>quantité</th>
        <th>retirer</th>
        <th>modifié</th>
    </tr>
    <% for(int i=0; i<lp.size(); i++){
          
    %>
    <tr>
        <th><%= lp.get(i).getCodeBarre() %></th>
        <th><%= lp.get(i).getNom() %></th> 
        <th><%= lp.get(i).getCategorie() %></th>
        <th><%= lp.get(i).getPrix() %></th>
        <th><%= lp.get(i).getQuantite() %> </th>
        <th><a href=supp.do?action=supProd&codeProduit=<%=lp.get(i).getCodeProduit()%> >retirer</a></th>
        <th><a href=mod.do?action=modProd&codeProduit=<%=lp.get(i).getCodeProduit()%> >modifier</a></th>
    </tr>
    <% }%>
    
</table>

</body>
</html>