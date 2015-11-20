<%-- 
    Document   : index
    Created on : 5-Oct-2015, 3:25:20 PM
    Author     : Louis-Étienne Lemire
--%>

<%@page import="com.magasin.entities.Acheteur"%>
<%
    if (session.getAttribute("connecte")==null)  // connecté
    {
%>
        <jsp:forward page="login.jsp" />
<%
    }
%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple de MVC</title>
        <style type="text/css">
            .errorMessage {color : red;}
            .resultat {font-weight: bold;}
        </style>
    </head>
    <body>  
                
    <%
    if (session.getAttribute("connecte").equals("admin") && session.getAttribute("connecte")!=null)  //déjà connecté admin
    {
    %>        
    
    <% /* <jsp:forward page="ajouterProduit.jsp" /> */%>
    <jsp:forward page="listProdAdm.jsp" />
    <%
    }
    
        if (session.getAttribute("connecte")!=null)
        {
            out.println("<p class=\"resultat\">"+(((Acheteur) request.getSession().getAttribute("acheteur")).getCourriel())+", vous êtes connectés. "+
                        "<a href=\"logout.do?action=logout\">déconnexion</a></p>");

        }        
%>
        <%
        if (request.getAttribute("message")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
       // String  ns1 = request.getParameter("nb1"),
       //         ns2 = request.getParameter("nb2"),
        String    ops = request.getParameter("operation"),
                selected=" selected=\"selected\"";
       // if (ns1==null) ns1="";
       // if (ns2==null) ns2="";
        
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
                            <h1>Vous êtes à la vue par défaut</h1>
                            <ul class="box">
                                <li><a href="ctrl.do?action=">Gestion de panier</a></li>  
                                <li><a href="ctrl.do?action=modifierCompte">Modification de compte</a></li>                        
                            </ul>
                            <%
                                }
                            %>
                        </div>
            
            
           
            
            <%--<jsp:include page = "" flush = "true"/>--%>
            
        <%
        //if (request.getAttribute("resultat")!=null)
       // {
        
            
        //    out.println("<span class=\"resultat\">"+request.getAttribute("resultat")+"</span>");
        //}
        %>
        
        
    </body>
</html>