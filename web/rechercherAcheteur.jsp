<%-- 
    Document   : rechercherAcheteur
    Created on : 2015-12-01, 17:18:23
    Author     : MonOrdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechercher acheteur</title>
    </head>
    <body>
        <h2>Rechercher un acheteur</h2>
        <div id="formRechercherAcheteur">
            <form action="rechercheAcheteur.do">
                <label>Courriel de l'acheteur : </label>
                <input type="text" name="courrielAcheteur" /><br /><br />
		<input type="image" src="images/boutonRechercher.jpg" />
                <input name="action" value="rechercheAcheteur" type="hidden" />
            </form>
            <%
            if (request.getAttribute("messageModificationAcheteur")!=null)
            {
                out.println("<p class=\"errorMessage\">"+request.getAttribute("messageModificationAcheteur")+"</p>");
            }
            %>
        </div>          
    </body>
</html>
