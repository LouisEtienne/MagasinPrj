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
@WebServlet(name = "rechercherProduit", urlPatterns = {"/rechercherProduit"})
public class RechercherProduit extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet rechercherProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet rechercherProduit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
        List<Produit> lp = new LinkedList<Produit>();        
        ProduitDAO daop = new ProduitDAO(Connexion.getInstance()); 
        if (request.getParameter("optionRecherche")!=null){
            char rech = request.getParameter("optionRecherche").charAt(0);
            switch (rech){
                case 'n': //nom
                    lp = daop.findAll //(request.getParameter("research"));
                    if (lp.size() > 0){
                        HttpSession sess = request.getSession();
                        sess.setAttribute("listeP", lp);
                        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/listeL.jsp");
                        r.forward(request, response);
                    }else{
                        request.setAttribute("message", "la recherche a rien trouvé");
                        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
                        r.forward(request, response);
                    }
                    break;
                case 'd'://recherche description
                    lp = daop.findAll //(request.getParameter("research"));
                    if (lp.size() > 0){
                        HttpSession sess = request.getSession();
                        sess.setAttribute("listeP", lp);
                        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/listeL.jsp");
                        r.forward(request, response);
                    }else{
                        request.setAttribute("message", "la recherche a rien trouvé"); 
                        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
                        r.forward(request, response);
                    }
                case 'm'://recherche mot cle
                    lp = daop.findAll //(request.getParameter("research"));
                    if (lp.size() > 0){
                        HttpSession sess = request.getSession();
                        sess.setAttribute("listeP", lp);
                        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/listeL.jsp");
                        r.forward(request, response);
                    }else{
                        request.setAttribute("message", "la recherche a rien trouvé");
                        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
                        r.forward(request, response);
                    }
                break;                    
                default:
                    request.setAttribute("message", "recherche échouée");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
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
