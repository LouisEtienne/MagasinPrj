<%@page import="com.magasin.entities.Taxes"%>
<%@page import="java.util.List"%>
<%@page import="com.magasin.entities.Panier"%>
<!DOCTYPE html>
<html>
<head>
<title>Payer</title>
</head>
<% 
    Panier pan = (Panier)session.getAttribute("Panier");
    double p=0;
     //List <Produit> lp = (List<Produit>)session.getAttribute("listeP"); 
%>
<body>

    <h1>Payer</h1>
    <% for(int i=0; i<pan.getListeProduits().size(); i++){

    %>
	<ul>
            <li><%= pan.getListeProduits().get(i).getNom() + " x " 
                    + pan.getListeProduits().get(i).getQuantite() + " = "%></li>
            <% p +=  pan.getListeProduits().get(i).getQuantite() * pan.getListeProduits().get(i).getPrix(); %>
	</ul>
	
	
    <%
        }
    %><br>
    <% p = Taxes.getMontantTotal(p); %>
    Total : <%= p + " $" %><br>
    Carte de credit: <select>
                            <option>Tazki</option>
                            <option>987654321</option>
                        </select><br><br>
	<input type="button" class="bouton" value="Payer">
	<input type="button" class="bouton" value="Annuler">
</body>
</html>