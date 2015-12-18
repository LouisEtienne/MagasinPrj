/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.web.mvc;

import com.magasin.entities.Acheteur;
import com.magasin.entities.Panier;
import com.magasin.entities.Produit;
import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.ProduitDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author usager
 */
@WebServlet(name = "RetirerProduit", urlPatterns = {"/RetirerProduit"})
public class RetirerProduit extends HttpServlet {
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
        
        HttpSession session = request.getSession(true);
        if (session.getAttribute("Panier") == null){
            Acheteur a = (Acheteur)session.getAttribute("acheteur");
            Panier pan = new Panier(a);
        }
        ProduitDAO daop = new ProduitDAO(Connexion.getInstance());
        Panier pan = (Panier) session.getAttribute("Panier");
        Produit p = daop.read(request.getParameter("codeP"));
 
        for (int i=0;i<pan.getListeProduits().size();i++)
        {
            if //( pan.getListeProduits().get(i).equals(p)){
                ( pan.getListeProduits().get(i).getCodeProduit().equals(p.getCodeProduit()) ){
                pan.getListeProduits().remove(i);
                session.setAttribute("Panier", pan);
                request.setAttribute("message",p.getNom()+" supprimé(es).");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=panier");
                r.forward(request, response);
            }
        }
            request.setAttribute("message", "Erreur lors de la suppression du produit du panier");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=panier");
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
