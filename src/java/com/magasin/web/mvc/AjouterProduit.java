/**
 *
 * @author Marie
 */

package com.magasin.web.mvc;

import com.magasin.entities.Produit;
import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.ProduitDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Marie
 */
@WebServlet(name = "AjouterProduit", urlPatterns = {"/AjouterProduit"})
public class AjouterProduit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    boolean tryParseDbl(String value) {  
        try {  
            Double.parseDouble(value);  
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ajouterProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ajouterProduit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/


       /*if (tryParseInt(input)) {  
          Integer.parse(input);  // We now know that it's safe to parse
       }*/
        
        String s = request.getParameter("codeP").substring(0, 4);
        
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        ProduitDAO pdao = new ProduitDAO(Connexion.getInstance());
        Produit p = new Produit();
        p =  pdao.read(request.getParameter("codeP"));
        if (p != null){
            request.setAttribute("message", "produit "+p.getNom()+" est déja existant.");
            //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
            r.forward(request, response);
        }else if(!tryParseDbl(request.getParameter("codeBarreP"))){
            request.setAttribute("message", "le code barre doit être composé de chiffres.");
            //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
            r.forward(request, response);           
        }else if(tryParseDbl(s) == true){
            request.setAttribute("message", "le code produit doit commencer avec 4 lettres et finir avec 6 chiffres.");
            //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
            r.forward(request, response); 
        }else{
            p = new Produit();
            p.setCategorie(request.getParameter("catP"));
            p.setCodeBarre(request.getParameter("codeBarreP"));
            p.setCodeProduit(request.getParameter("codeP"));
            p.setNom(request.getParameter("nomP"));
            p.setPrix(request.getParameter("prixP"));
            p.setQuantite(request.getParameter("qteP"));
            
            if(pdao.create(p))
            {
                //Utilisateur inexistant creation
                //request.setAttribute("message", "Mot de passe incorrect.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=payer");
                r.forward(request, response);
            }
            else{
                //Utilisateur inexistant creation
                request.setAttribute("message", "erreur lors de la creation.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=panier");
                r.forward(request, response);
            }
            
            
        }
        //http://stackoverflow.com/questions/10281962/is-there-a-minlength-validation-attribute-in-html5
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}