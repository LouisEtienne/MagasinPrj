/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.web.mvc;

import com.magasin.entities.Acheteur;
import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.AcheteurDao;
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
 * @author MonOrdi
 */
@WebServlet(name = "RechercherAcheteur", urlPatterns = {"/RechercherAcheteur"})
public class RechercherAcheteur extends HttpServlet {

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
      
        String unCourrielAcheteur = request.getParameter("courrielAcheteur");
        if(!unCourrielAcheteur.equals("")) {
            AcheteurDao unAcheteurDAO = new AcheteurDao(Connexion.getInstance());
            Acheteur unAcheteur = unAcheteurDAO.read(unCourrielAcheteur.trim());
            if(unAcheteur != null)
            {
                request.setAttribute("unAcheteur", unAcheteur);
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompteAdmin");
                r.forward(request, response);                 
            }
            else {
                request.setAttribute("messageModificationAcheteur", "Acheteur inexistant.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=rechercherAcheteur");
                r.forward(request, response);
            }
        }
        else {
            request.setAttribute("messageModificationAcheteur", "Le champ est vide.");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=rechercherAcheteur");
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
