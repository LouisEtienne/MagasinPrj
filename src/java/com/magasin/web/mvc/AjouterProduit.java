/**
 *
 * @author Marie
 */

package com.magasin.web.mvc;

import com.magasin.entities.Produit;
import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.ProduitDAO;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
        
        String s = request.getParameter("codeP").substring(0, 4);
        HttpSession session = request.getSession();
        
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        ProduitDAO pdao = new ProduitDAO(Connexion.getInstance());
        Produit p = new Produit();
        String categorie;
        List<String> listeCategories = new LinkedList<String>();
        listeCategories = pdao.findCategorie();
        
        p = pdao.read(request.getParameter("codeP"));
        if (p != null){
            request.setAttribute("listeCategories", listeCategories);
            request.setAttribute("messageCreation", "produit "+p.getNom()+" est déja existant.");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
            r.forward(request, response);
        }
        else 
        {  
            if(!tryParseDbl(request.getParameter("codeBarreP"))){
                request.setAttribute("listeCategories", listeCategories);
                request.setAttribute("messageCreation", "Le code barre doit être composé de chiffres.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
                r.forward(request, response);           
            }
            if(tryParseDbl(s) == true){
                request.setAttribute("messageCreation", "Le code produit doit commencer avec 4 lettres et finir avec 6 chiffres.");
                request.setAttribute("listeCategories", listeCategories);
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
                r.forward(request, response); 
            } 
            p = new Produit();
            if(request.getParameter("catP").equals("")) {
                if(request.getParameter("categorie").equals("nouvelleCategorie")) {
                    request.setAttribute("messageCreation", "Choisir un élément de la liste ou saisir une nouvelle catégorie.");
                    request.setAttribute("listeCategories", listeCategories);
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
                    r.forward(request, response);                 
                }
                    categorie = request.getParameter("categorie");
            }
            else {
                categorie = request.getParameter("catP");
            }
            p.setCategorie(categorie);
            p.setCodeBarre(request.getParameter("codeBarreP"));
            p.setCodeProduit(request.getParameter("codeP"));
            p.setNom(request.getParameter("nomP"));
            p.setPrix(Double.parseDouble(request.getParameter("prixP")));
            p.setQuantite(Integer.parseInt(request.getParameter("qteP")));
            
            if(pdao.create(p))
            {
                List <Produit> lp = new LinkedList<Produit>();
                lp = pdao.findAll();
                session.setAttribute("listeP",lp);
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=listProdAdm");
                r.forward(request, response);
            }
            else{
                request.setAttribute("listeCategories", listeCategories);
                request.setAttribute("messageCreation", "Erreur lors de la création.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
                r.forward(request, response);
            }
            
            
        }
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