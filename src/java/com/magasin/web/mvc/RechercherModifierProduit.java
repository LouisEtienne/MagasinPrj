/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author usager
 */
@WebServlet(name = "RechercherModifierProduit", urlPatterns = {"/RechercherModifierProduit"})
public class RechercherModifierProduit extends HttpServlet {

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
        
        String codeProduit = request.getParameter("codeP");
        
        if(!codeProduit.equals("")) {
            ProduitDAO unProduitDAO = new ProduitDAO(Connexion.getInstance());
            Produit produit = unProduitDAO.read(codeProduit);
            if(produit == null) {
                request.setAttribute("messageErreur", "Ce code produit n'existe pas.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=rechercherModifierProduit");
                r.forward(request, response);                
            }
            else {
                List<String> listeCategories = new LinkedList<String>();
                ProduitDAO listeCategoriesDAO = new ProduitDAO(Connexion.getInstance());
                listeCategories = listeCategoriesDAO.findCategorie();  
                request.setAttribute("listeCategories", listeCategories);
                request.setAttribute("produit", produit);
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierProduit");
                r.forward(request, response);
            }
        }
        else {
            request.setAttribute("messageErreur", "Le champ est vide.");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=rechercherModifierProduit");
            r.forward(request, response);            
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
