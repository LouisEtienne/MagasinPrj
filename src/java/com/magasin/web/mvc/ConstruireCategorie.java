/**
 * Cette servlet sert à construire une liste de catégories à afficher pour
 * la page Ajouter un produit dans la section administrateur.
 * Fichier: ConstruireCategorie.java
 * Programmeur: Michel Plamondon
 * Date: 2015-12-16
 */
package com.magasin.web.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.ProduitDAO;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author MonOrdi
 */
@WebServlet(name = "ConstruireCategorie", urlPatterns = {"/ConstruireCategorie"})
public class ConstruireCategorie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<String> listeCategories = new LinkedList<String>();
        ProduitDAO listeCategoriesDAO = new ProduitDAO(Connexion.getInstance());
        listeCategories = listeCategoriesDAO.findCategorie();
        
        request.setAttribute("listeCategories", listeCategories);
        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
        r.forward(request, response);       
        
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
