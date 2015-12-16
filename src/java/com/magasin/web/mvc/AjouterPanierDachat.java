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
 * @author usager
 */
@WebServlet(name = "AjouterPanierDachat", urlPatterns = {"/AjouterPanierDachat"})
public class AjouterPanierDachat extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");/*
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjouterPanierDachat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjouterPanierDachat at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
        HttpSession session = request.getSession(true);
        if (session.getAttribute("Panier") == null){
            Acheteur a = (Acheteur)session.getAttribute("acheteur");
            Panier pan = new Panier(a);
        }
        ProduitDAO daop = new ProduitDAO(Connexion.getInstance());
        Panier pan = (Panier) session.getAttribute("Panier");
        Produit p = daop.read(request.getParameter("codeProduit"));
        //la qté choisie par l'acheteur
        
        if(p != null ){
            p.setQuantite(Integer.parseInt(request.getParameter("qteProd")));
            pan.ajouterProduit(p);

            request.setAttribute("message", p.getNom()+" ajouté(es).");
            session.setAttribute("Panier", pan);
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=panier");
            r.forward(request, response);
        }else{
            request.setAttribute("message", " erreur dans l'ajout du produit");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=ajouterProduit");
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
