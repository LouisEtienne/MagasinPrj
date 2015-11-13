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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Louis
 */
@WebServlet(name = "MAJcompte", urlPatterns = {"/MAJcompte"})
public class MAJcompte extends HttpServlet {

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
 
        
        String courriel = (((Acheteur) request.getSession().getAttribute("acheteur")).getCourriel());
//        String mdp = request.getParameter("motdepasse");
//        String confirmdp = request.getParameter("motdepasseconfirme");
//        String nom = request.getParameter("nom");
//
//        String prenom = request.getParameter("prenom");
//        String adresse = request.getParameter("adresse");
//
//        String telephoneprincipal = request.getParameter("telephoneprincipal");
//        String telephonesecondaire = request.getParameter("telephonesecondaire");
//
//        String ville = request.getParameter("ville");
//        String province = request.getParameter("province");
//
//        String codepostal = request.getParameter("codepostal");
//        String numero = request.getParameter("numero");
//            String etat = request.getParameter("etat");
//            int monEtat;
//            monEtat = (etat.equals("1")) ? 1 : 0;
//            Acheteur a1 = new Acheteur(user,mdp,numero,nom,prenom,adresse,ville,province,codepostal,telephoneprincipal,telephonesecondaire,monEtat);
     AcheteurDao Achetdao = new AcheteurDao(Connexion.getInstance());
       
       Acheteur acheteur = Achetdao.read(courriel);
       request.setAttribute("acheteur",acheteur);
       RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompte");  //redirection vers la servlet login
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
