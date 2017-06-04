package co.edu.uniminuto.estampatejsfejb.servlets;

import co.edu.uniminuto.estampatejsfejb.entitys.Producto;
import co.edu.uniminuto.estampatejsfejb.session.ColoresFacade;
import co.edu.uniminuto.estampatejsfejb.session.CompradoresFacade;
import co.edu.uniminuto.estampatejsfejb.session.EstampasFacade;
import co.edu.uniminuto.estampatejsfejb.session.EstilosFacade;
import co.edu.uniminuto.estampatejsfejb.session.ProductoFacade;
import co.edu.uniminuto.estampatejsfejb.session.TallasFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "crearProducto", urlPatterns = {"/crearProducto"})
public class crearProducto extends HttpServlet {

    @EJB
    EstampasFacade estampasFacade;
    @EJB
    ColoresFacade coloresFacade;
    @EJB
    TallasFacade tallasFacade;
    @EJB
    EstilosFacade estilosFacade;
    @EJB
    CompradoresFacade compradoresFacade;
    @EJB
    ProductoFacade productoFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Producto objProducto = new Producto(null, 1, coloresFacade.find(Integer.parseInt(request.getParameter("idColor"))), compradoresFacade.find(2), estampasFacade.find(Integer.parseInt(request.getParameter("idEstampa"))), estilosFacade.find(Integer.parseInt(request.getParameter("idEstilo"))), tallasFacade.find(Integer.parseInt(request.getParameter("idTalla"))));
        productoFacade.create(objProducto);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet crearProducto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet crearProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
