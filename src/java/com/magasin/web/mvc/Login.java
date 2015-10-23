/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package com.magasin.web.mvc;

import com.magasin.entities.Acheteur;
import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.AcheteurDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Louis
 */
@WebServlet(name = "login", urlPatterns = {"/signin"})
public class Login extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  u = request.getParameter("username"),
                p = request.getParameter("password");
        if (u==null || u.trim().equalsIgnoreCase(""))
        {
            //Utilisateur inexistant
            request.setAttribute("message", "Username obligatoire");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);
            return;
        }

        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        AcheteurDao dao = new AcheteurDao(Connexion.getInstance());
        Acheteur acheteur = dao.read(u.trim());
        
        if (acheteur==null)
        {
            //Utilisateur inexistant
            request.setAttribute("message", "Utilisateur "+u+" inexistant.");
            //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);
        }
        else if (!acheteur.getMotPasseAcheteur().equals(p))
        {
            //Mot de passe incorrect
            request.setAttribute("message", "Mot de passe incorrect.");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);
        }
        else
        {
            //connexion OK
            HttpSession session = request.getSession(true);
            session.setAttribute("connecte", u);
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
            r.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
