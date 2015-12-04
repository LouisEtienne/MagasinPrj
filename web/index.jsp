<%-- 
    Document   : index
    Created on : 5-Oct-2015, 3:25:20 PM
    Author     : Louis-Étienne Lemire
--%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion sur le magasin de Louis-&Eacute;tienne inc.</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id='contenu'>
            <div id='entete'>
                <h1>Bienvenue sur le magasin de Louis-&Eacute;tienne inc.</h1>
            </div>
            <%@page import="com.magasin.entities.Administrateur"%>
            <%@page import="com.magasin.entities.Acheteur"%>
            <%
                if ((session.getAttribute("connecte")==null) && (session.getAttribute("connecteadmin")==null))
                {
            %>
                    <jsp:forward page="login.jsp" />
            <%
                }
                /*if (request.getAttribute("message")!=null)
                {
                    out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
                }*/
                if (session.getAttribute("connecte")!=null)
                {
            %>
                <div id='menu'>
                    <ul>                  
                        <li><a href="ctrl.do?action=modifierCompte">Modification de compte</a></li>
                        <li><a href="?">Gestion du panier</a></li>
                        <li><a href="index.jsp?vue=rechercheProduit">Rechercher un produit</a></li>                    
                        <li><a href="index.jsp?vue=listProd">consulter les produits</a></li>
                        <li><a href="logout.do?action=logout">D&eacute;connexion</a></li>
                    </ul>
                </div>
            <%
            }
            else if (session.getAttribute("connecteadmin")!=null)
            {
            %>
                <div id='menuadmin'>
                    <ul>                        
                        <li><a href="index.jsp?vue=rechercherAcheteur">Modifier profil acheteur</a></li>
                        <li><a href="index.jsp?vue=ajouterProduit">Ajouter un produit</a></li>
                        <li><a href="index.jsp?vue=rechercherModifierProduit">Modifier un produit</a></li>
                        <li><a href="index.jsp?vue=rechercherSupprimerProduit">Supprimer un produit</a></li>
                        <li><a href="ctrl.do?action=listeProd">Liste de produits</a></li>
                        <li><a href="logout.do?action=logout">D&eacute;connexion</a></li>
                    </ul>
                </div>
            <%
            }     
            %>
            <div id="centre">
            <%
                String vue = request.getParameter("vue");
                if (vue==null)
                    vue = (String)request.getAttribute("vue");
                    if (vue != null) 
                    {
                        vue = vue+".jsp";                    
            %>
                <jsp:include page="<%=vue%>" />
            <%                    
                    }
                   else
                    {
            %>
                        <h1>Erreur 404</h1>
<!--                        <ul class="box">
                        <li><a href="ctrl.do?action=">Gestion de panier</a></li>  
                        <li><a href="ctrl.do?action=modifierCompte">Modification de compte</a></li>                        
                        </ul>-->
            <%
                    }
            %>
            </div>    
        </div>
    </body>
</html>