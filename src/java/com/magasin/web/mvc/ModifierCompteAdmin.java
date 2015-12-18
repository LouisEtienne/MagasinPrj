/**
 * Cette servlet sert pour l'administrateur à modifier les informations
 * personnelles sur un acheteur.
 * Fichier : ModifierCompteAdmin.java
 * Date de création : 2015-11-22
 * @author Louis-Étienne Lemire et Simon Brunet-Carrière
 * @version 1.0
 * Date de modification: 2015-12-08
 * Modifié par Michel Plamondon
 */
package com.magasin.web.mvc;

import com.magasin.entities.Acheteur;
import com.magasin.entities.Validation;
import com.magasin.jdbc.Connexion;
import com.magasin.jdbc.dao.implementation.AcheteurDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModifierCompteAdmin", urlPatterns = {"/ModifierCompteAdmin"})
public class ModifierCompteAdmin extends HttpServlet {

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
        
        String user = request.getParameter("courriel");
        String mdp = request.getParameter("motdepasse");
        String confirmdp = request.getParameter("motdepasseconfirme");
        String nom = request.getParameter("nom");

        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");

        String telephoneprincipal = request.getParameter("telephoneprincipal");
        String telephonesecondaire = request.getParameter("telephonesecondaire");

        String ville = request.getParameter("ville");
        String province = request.getParameter("province");

        String codepostal = request.getParameter("codepostal");
        String numero = request.getParameter("numero");
        String etatChaine = request.getParameter("etat");
        int etat = 0;
        
        if(etatChaine.equals("actif")) {
            etat = 1;
        }
        Acheteur a1 = new Acheteur(user,mdp,numero,nom,prenom,adresse,ville,province,codepostal,telephoneprincipal,telephonesecondaire,etat);        
        Validation valid = new Validation();
            
        if (!telephoneprincipal.equals("") && !valid.pregMatchTele(telephoneprincipal))
        {
            request.setAttribute("unAcheteur", a1);
            request.setAttribute("message", "Numéro de téléphone invalide");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompteAdmin");
            r.forward(request, response);
        }
        
        if (!telephonesecondaire.equals("") && !valid.pregMatchTele(telephonesecondaire))
        {
            request.setAttribute("unAcheteur", a1);
            request.setAttribute("message", "Numéro de téléphone secondaire invalide");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompteAdmin");
            r.forward(request, response);
        }
        
        if (!codepostal.equals("") && !valid.pregMatchCodePostal(codepostal))
        {
            request.setAttribute("unAcheteur", a1);
            request.setAttribute("message", "Code postal invalide");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompteAdmin");
            r.forward(request, response);
        }
        
        if (!numero.equals("") && !valid.pregMatchCredit(numero))
        {
            request.setAttribute("unAcheteur", a1);
            request.setAttribute("message", "Numéro de carte invalide");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompteAdmin");
            r.forward(request, response);
        }
        
        if (!mdp.equals(confirmdp))
        {
            request.setAttribute("unAcheteur", a1);
            request.setAttribute("message", "Mot de passe différent");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompteAdmin");
            r.forward(request, response);
        }         
        AcheteurDao Achetdao = new AcheteurDao(Connexion.getInstance());
        Achetdao.update(a1);
        request.setAttribute("message", "Le compte de l'acheteur " + a1.getCourriel() + " a &eacute;t&eacute; modifi&eacute.");
        request.setAttribute("unAcheteur", a1);
        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierCompteAdmin");  //redirection vers la servlet login
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
