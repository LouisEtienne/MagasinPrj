/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package com.magasin.web.mvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Louis
 */
@WebServlet(name = "Controleur", urlPatterns = {"*.do"})
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
            if ("loginAcheteur".equals(action))
            {                
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signin");  //redirection vers la servlet de connexion Acheteur
                r.forward(request, response);
                return;         
            } 
        
            if ("loginAdmin".equals(action))
            {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signin");  //redirection vers la servlet de connexion Admin
                r.forward(request, response);
                return;
            }  
        
            if ("logout".equals(action))
            {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signout");  //redirection vers la déconnexion
                r.forward(request, response);
                return;
            }
            
            if("creerCompte".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/creerCompte.jsp");  //redirection vers la servlet création de compte
                r.forward(request, response);
                return;
            }
            if("compteCree".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/CreationCompte");  //redirection vers la servlet login
                r.forward(request, response);
                return;
            }
            
            if("modifierCompte".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/MAJcompte");  //redirection vers le formulaire de mise à jour du compte
                r.forward(request, response);
                return;
            }
            if("produitModifie".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ProduitModifie");  //
                r.forward(request, response);
                return;
            }
            if("compteModifie".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ModifierCompte");  //redirection vers la servlet modifier compte
                r.forward(request, response);
                return;
            }
            if("ajouterPanier".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/AjouterPanierDachat");  //redirection vers la servlet modifier compte
                r.forward(request, response);
                return;
            }
            if("listeProd".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ListeProduit");  //
                r.forward(request, response);
                return;
            }
            if("ajouterProd".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/AjouterProduit");
                r.forward(request, response);
                return;
            }
            if("supProd".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/SupprimerProduit");
                r.forward(request, response);
                return;
            }
            if("rechercheAcheteur".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/RechercherAcheteur");
                r.forward(request, response);
                return;
            }
            if("rechercherProd".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/RechercherProduit");
                r.forward(request, response);
                return;
            } 
            if("modProd".equals(action)){
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/MAJproduit");
                r.forward(request, response);
                return;
            }
            if ("annulation".equals(action))
            {                
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");  //redirection vers l'index
                r.forward(request, response);
                return;        
            }
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
