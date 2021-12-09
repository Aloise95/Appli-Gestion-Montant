/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author benoit
 */
public class LectureParametresAvecStockage extends HttpServlet {

    String dernierNom = null;
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
        PrintWriter out = response.getWriter();
        String nomParametre=null;
        String[] valeursParametre=null;
        Iterator it;
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet lecture paramètres</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<hr>");
            // récupération d'un paramètre unique par son nom
            out.println("nom : ");
            out.println(request.getParameter("nom"));
            out.println("(le dernier nom était: " + dernierNom + ")");
            dernierNom = request.getParameter("nom");
            out.println("<br>");
            // J'attends 10 secondes !
            /*
            try {
                Thread.sleep(10000);
            } 
            catch(InterruptedException ex) { 
                Thread.currentThread().interrupt();
            }
            */
            out.println("prénom : ");
            out.println(request.getParameter("prenom"));
            out.println("<br>");
            // récupération des valeurs multiples d'un paramètre
            String[] loisirs=null;
            loisirs=request.getParameterValues("loisirs");
            out.println("loisirs :");
            for(String loisir:loisirs)
            {
                out.println(loisir + " ");
            }
            out.println("<hr>");
            out.println("<br>");
            // récupération des noms des paramètres
            Enumeration parametres=null;
            out.println("liste des noms de paramètres");
            out.println("<br>");
            parametres=request.getParameterNames();
            while (parametres.hasMoreElements())
            {
                out.println(parametres.nextElement());
            }
             out.println("<hr>");
            out.println("<br>");
            // récupération des noms des paramètres
            out.println("liste des paramètres sans connaitre le nom");
            out.println("<br>");
            // récupération d'un itérateur sur les clés (nom des paramètres)
            it=request.getParameterMap().keySet().iterator();
            // boucle de parcours de la liste des paramètres
            while(it.hasNext())
            {
                nomParametre=(String)it.next();
                out.println("nom du parametre : ");
                out.println(nomParametre);
                out.println(" valeurs du parametre :");
                valeursParametre=(String[])request.getParameterMap().get(nomParametre);
                for(String valeurParametre:valeursParametre)
                {
                    out.println(valeurParametre);
                    out.println(";");
                }
                out.println("<br>");
            }
        } finally { 
            out.close();
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
