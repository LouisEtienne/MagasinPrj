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
 * @author usager
 */
@WebServlet(name = "ProduitModifie", urlPatterns = {"/ProduitModifie"})
public class ProduitModifie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    boolean tryParseDbl(String value) {  
        try {  
            Double.parseDouble(value);  
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String s = request.getParameter("codeP").substring(0, 4);
        
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        ProduitDAO pdao = new ProduitDAO(Connexion.getInstance());
        Produit p = new Produit();
        p =  pdao.read(request.getParameter("codeP"));
        System.out.println("update");
        if (p == null){
            request.setAttribute("messageProduit", "Le produit "+p.getNom()+" n'existe pas.");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=listProdAdm");
            r.forward(request, response);
        }else { 
            
            if(!tryParseDbl(request.getParameter("codeBarreP"))){
                request.setAttribute("messageProduit", "Le code barre doit être composé de chiffres.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=listProdAdm");
                r.forward(request, response); 
            }
            if(tryParseDbl(s) == true){
                request.setAttribute("messageProduit", "Le code produit doit commencer avec 4 lettres et finir avec 6 chiffres.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=listProdAdm");
                r.forward(request, response);
            }
            p = new Produit();
            p.setCategorie(request.getParameter("catP"));
            p.setCodeBarre(request.getParameter("codeBarreP"));
            p.setCodeProduit(request.getParameter("codeP"));
            p.setNom(request.getParameter("nomP"));
            p.setPrix(Double.parseDouble(request.getParameter("prixP")));
            p.setQuantite(Integer.parseInt(request.getParameter("qteP")));
            
            if(pdao.update(p))
            {
                List <Produit> lp = new LinkedList<Produit>();
                lp = pdao.findAll();
                HttpSession session = request.getSession();
                session.setAttribute("listeP",lp);
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=listProdAdm");
                r.forward(request, response);
            }
            else{
                request.setAttribute("messageModification", "Erreur lors de la modification.");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?vue=modifierProduit");
                r.forward(request, response);
            } 
            
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
