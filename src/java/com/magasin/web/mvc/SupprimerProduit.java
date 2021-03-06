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
import java.io.PrintWriter;
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
@WebServlet(name = "SupprimerProduit", urlPatterns = {"/SupprimerProduit"})
public class SupprimerProduit extends HttpServlet {

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

            HttpSession session = request.getSession();
            Produit p = new Produit();//= (Produit)session.getAttribute("produit");
            //List <Produit> lp = new LinkedList<Produit>();
            ProduitDAO pdao = new ProduitDAO(Connexion.getInstance());
            p.setCodeProduit(request.getParameter("codeP"));
            if(pdao.delete(p)){
                //recharger la liste
                List <Produit> lp = new LinkedList<Produit>();
                lp = pdao.findAll();
                session.setAttribute("listeP",lp);
                request.setAttribute("messageProduit", "Produit supprimé avec succès.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=listProdAdm");
                r.forward(request, response);
            }else{
                request.setAttribute("messageProduit", "Échec lors de la supression du produit.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=listProdAdm");
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
