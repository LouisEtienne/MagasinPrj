<%-- 
    Document   : index
    Created on : 5-Oct-2015, 3:25:20 PM
    Author     : Louis-Étienne Lemire
--%>

<%
    if (session.getAttribute("connecte")==null)  //déjà connecté
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
        if (session.getAttribute("connecte")!=null)
        {
            out.println("<p class=\"resultat\">"+session.getAttribute("connecte")+", vous êtes connectés. "+
                        "<a href=\"logout.do?action=logout\">déconnexion</a></p>");

        }        
%>
        <h1>MVC</h1>
        <%
        if (request.getAttribute("message")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
        String  ns1 = request.getParameter("nb1"),
                ns2 = request.getParameter("nb2"),
                ops = request.getParameter("operation"),
                selected=" selected=\"selected\"";
        if (ns1==null) ns1="";
        if (ns2==null) ns2="";
        %>
        <form action="abc.do" method="post">
            
            <select name="operation">
                <option value="">--choisir--</option>
                <option value="création de compte" <%="+".equals(ops)?selected:""%>>+</option>
                <option value="modification de compte" <%="-".equals(ops)?selected:""%>>-</option>
            </select>
           
            <input type="submit" value=" Submit " />
        <%
        if (request.getAttribute("resultat")!=null)
        {
            //double x = ((Double)request.getAttribute("resultat")).doubleValue();
            out.println("<span class=\"resultat\">"+request.getAttribute("resultat")+"</span>");
        }
        %>
        </form>
        
    </body>
</html>