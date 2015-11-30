<%-- 
    Document   : rechercherProduitAdmin
    Created on : 2015-11-27, 09:08:47
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechercher un produit  pour la suppression</title>
    </head>
    <body>
        <h1>Rechercher un produit pour la suppression</h1>
        <div id="formRechercherProduit">
            <form>
                <label for="labelcodearechercher"> Code produit &agrave; rechercher : </label>
                <input type="text" name="codeProduit" /><br /><br />
		<input type="image" src="images/boutonSupprimer.jpg" />
                <input name="action" value="supProd" type="hidden" />
            </form>
            <%
            if (request.getAttribute("messageErreur")!=null)
            {
                out.println("<p class=\"errorMessage\">"+request.getAttribute("messageErreur")+"</p>");
            }
            %>
        </div>    
    </body>
</html>
