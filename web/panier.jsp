<%@page import="com.magasin.entities.Panier"%>
<!DOCTYPE html>
<html>
<head>
<title>Panier</title>
<% 
    Panier pan = (Panier)session.getAttribute("Panier");
    
%>
</head>
<body>
    <%
        if (request.getAttribute("message")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
        
    %>

<h1>Panier d'achat</h1>
    <%if(pan.getListeProduits().size() == 0) 
    {  
    %>
    <h2>Panier Vide</h2>
    <%
    }    
    %>
	<table>
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
        <form action="voirPanier.do">
            <input type="hidden" name="action" value="voirPanier">
            <input type="submit"  class="bouton" value="Voir la facture">
        </form>
	
</body>
</html>