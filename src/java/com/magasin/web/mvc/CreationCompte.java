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
 * @author usager
 */
@WebServlet(name = "CreationCompte", urlPatterns = {"/CreationCompte"})
public class CreationCompte extends HttpServlet {

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
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        AcheteurDao dao = new AcheteurDao(Connexion.getInstance());
        Acheteur ach = dao.read(request.getParameter("courr").trim());

            if (ach!=null || request.getParameter("courr").equals("admin") 
                    || request.getParameter("courr").equals(""))
            {
                    //Utilisateur existant
                    //request.setAttribute("message", "Utilisateur "+ach.getNomAcheteur()+" déja existant.");
                    request.setAttribute("message", "Utilisateur avec l'adresse \'"+request.getParameter("courr")+ "' déja existant.");
                    //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=creerCompte");
                    r.forward(request, response);

            }else if (!request.getParameter("pass").equals(request.getParameter("passConf"))){
                    request.setAttribute("message", "les deux mots de passe ne sont pas semblables");
                    //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=creerCompte");
                    r.forward(request, response);
            }else{
                String adresse =request.getParameter("adre");
                String codePostal= request.getParameter("cPos");
                int compteActif = 1;
                String courriel =request.getParameter("courr");
                String ville = request.getParameter("ville");
                String telPrincipal = request.getParameter("phone");
                String telSecondaire = request.getParameter("phone2");
                String province = request.getParameter("pro");
                String prenom = request.getParameter("pren");
                String nom = request.getParameter("nom");
                String numero = request.getParameter("cred");
                String motDePasse = request.getParameter("pass");
                        
                ach = new Acheteur();
                ach.setAdresse(adresse);
                ach.setCodePostal(codePostal);
                ach.setCompteActif(compteActif);
                ach.setCourriel(courriel);
                ach.setVille(ville);
                ach.setTelephoneSecondaire(telSecondaire);
                ach.setTelephonePrincipal(telPrincipal);
                ach.setProvince(province);
                ach.setPrenomAcheteur(prenom);
                ach.setNomAcheteur(nom);
                ach.setNoCarteCredit(numero);
                ach.setMotPasseAcheteur(motDePasse);
                
                if(dao.create(ach))
                {
                    try {
                    Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CreationCompte.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Acheteur acheteur = dao.read(courriel.trim());
                    Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
                    HttpSession session = request.getSession(true);
                    session.setAttribute("connecte", courriel);
                    session.setAttribute(("acheteur"), acheteur);

            
                    //Utilisateur inexistant creation
                    //request.setAttribute("message", "Mot de passe incorrect.");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=panier");
                    r.forward(request, response);
                }
                else{
                    //Utilisateur inexistant creation
                    request.setAttribute("message", "Utilisateur existant.");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=creerCompte");
                    r.forward(request, response);
                }

            }
            
        /*try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreationCompte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreationCompte at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
        
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
