/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package com.magasin.web.mvc;

import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.AcheteurDao;
import com.magasin.jdbc.dao.implementation.AdministrateurDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
//@WebServlet(name = "Controleur", urlPatterns = {"/Controleur"})
public class Controleur extends HttpServlet {
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String u = request.getParameter("user"),
               p = request.getParameter("pass");
        
        if (action !=null)
        {
        if ("loginAcheteur".equals(action) || "loginAdmin".equals(action))
            {                
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signin");  //redirection vers la servlet login
                r.forward(request, response);
                return;
                
                /*
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                }

                Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
                Connection cnx = Connexion.getInstance();
                AcheteurDao dao = new AcheteurDao(cnx);
                if (!dao.checkLogin(u,p))
                {
                    request.setAttribute("message", "Courriel et/ou mot de passe erroné(s)");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
                    r.forward(request, response);
                    return;
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("connecte",u);
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
                    r.forward(request, response);
                }*/

            }   
        if ("loginAdmin".equals(action))
            {
                /*try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                }

                Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
                Connection cnx = Connexion.getInstance();
                AdministrateurDao dao = new AdministrateurDao(cnx);
                if (!dao.checkLogin(u,p))
                {
                    request.setAttribute("messageAdmin", "Code et/ou mot de passe erroné(s)");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
                    r.forward(request, response);
                    return;
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("connecte",u);
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
                    r.forward(request, response);
                }*/

            }  
            if ("logout".equals(action))
            {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signout");  //redirection vers la servlet login
                r.forward(request, response);
                return;
            }
            
            if("creerCompte".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/creerCompte.jsp");  //redirection vers la servlet login
                r.forward(request, response);
                return;
            }
            if("compteCree".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/CreationCompte");  //redirection vers la servlet login
                r.forward(request, response);
                return;
            }
            return;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
