<%@page import="com.magasin.entities.Panier"%>
<!DOCTYPE html>
<html>
<head>
<title>Panier</title>
<% Panier pan = (Panier)session.getAttribute("Panier"); %>
</head>
<body>
    <%
        if (request.getAttribute("message")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
        
    %>

<h1>Panier d'achat</h1>
	<table>
	  <tr>
		<th>produit</th>
		<th>prix</th>
		<th>quantit&eacute;</th>
		<th></th>
	  </tr>
	  <tr>
		<td>orange</td>
		<td>1</td>
		<td>5</td>
		<td><a href="google.com">retirer</a></td>		
	  </tr>
            <tr>
		<td>prod2</td>
		<td>2</td>
		<td>9</td>
		<td><a href="google.com">retirer</a></td>
            </tr>
            <% for(int i=0;i<pan.getListeProduits().size();i++){ %>
            <tr>                
		<td><%= pan.getListeProduits().get(i).getNom() %></td>
		<td><%= pan.getListeProduits().get(i).getQuantite() * pan.getListeProduits().get(i).getPrix() %> $</td>
		<td><%= pan.getListeProduits().get(i).getQuantite() %></td>
                <td><a href="ctrl.do?action=retirerProd&codeP=<%= pan.getListeProduits().get(i).getCodeProduit()%>">retirer</a></td>                        
               
            </tr>
            <%
            }
            %>
	</table> 
	<br />
	<input type="button"  class="bouton" value="Voir la facture">
</body>
</html>