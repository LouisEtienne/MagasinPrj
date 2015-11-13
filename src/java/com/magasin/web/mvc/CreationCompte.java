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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usager
 */
@WebServlet(name = "CreationCompte", urlPatterns = {"/creationCompte"})
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
        /*                  
        request.getParameter("courr");
        request.getParameter("pass");                    
        request.getParameter("passConf");
        request.getParameter("nom");        
        request.getParameter("pren");
        request.getParameter("adre");        
        request.getParameter("phone");
        request.getParameter("phone2");
        request.getParameter("ville");
        request.getParameter("pro");      
        request.getParameter("cPos");
        request.getParameter("cred");          
        */
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
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/creerCompte.jsp");
                    r.forward(request, response);

            }else if (!request.getParameter("pass").equals(request.getParameter("passConf"))){
                    request.setAttribute("message", "les deux mots de passe ne sont pas semblables");
                    //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/creerCompte.jsp");
                    r.forward(request, response);
            }else{
                ach = new Acheteur();
                ach.setAdresse(request.getParameter("adre"));
                ach.setCodePostal(request.getParameter("cPos"));
                ach.setCompteActif(true);
                ach.setCourriel(request.getParameter("courr"));
                ach.setVille(request.getParameter("ville"));
                ach.setTelephoneSecondaire(request.getParameter("phone2"));
                ach.setTelephonePrincipal(request.getParameter("phone"));
                ach.setProvince(request.getParameter("pro"));
                ach.setPrenomAcheteur(request.getParameter("pren"));
                ach.setNomAcheteur(request.getParameter("nom"));
                ach.setNoCarteCredit(request.getParameter("cred"));
                ach.setMotPasseAcheteur(request.getParameter("passConf"));
                
                if(dao.create(ach))
                {
                    //Utilisateur inexistant creation
                    //request.setAttribute("message", "Mot de passe incorrect.");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/payer.jsp");
                    r.forward(request, response);
                }
                else{
                    //Utilisateur inexistant creation
                    //request.setAttribute("message", "Mot de passe incorrect.");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/panier.jsp");
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
