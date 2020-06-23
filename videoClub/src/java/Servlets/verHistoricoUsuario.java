/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import conexion.ConnexionMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jspTag.reservas;

/**
 *
 * @author alvaro
 */
public class verHistoricoUsuario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            ArrayList<reservas> listaPagadas = new ArrayList<>();
            ArrayList<reservas> listaRecibidas = new ArrayList<>();
            request.setCharacterEncoding("UTF-8");
            // Creamos la sesión, si no estaba creada.
                HttpSession session = request.getSession(true);
            int id_Us = (Integer) session.getAttribute("id_Usuario");
            String nom_Us= (String)session.getAttribute("nombreUsuario");
            out.print(nom_Us);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ConnexionMySQL cn = new ConnexionMySQL();
                cn.obtenerConexion();
                listaPagadas = cn.listarHistorico(id_Us);
                listaRecibidas=cn.listarHistoricoRecibidos(id_Us);
                request.setAttribute("Recibidos", listaRecibidas);
                request.setAttribute("Pagados", listaPagadas);
                //Preparamos para enviar a Inicio.jsp
                RequestDispatcher myDispatcher = request.getRequestDispatcher("./HistoricoUsuario.jsp");
                
                //Envio
                myDispatcher.forward(request, response);
                cn.desconectar();
            } catch (Exception e) {
                out.print("Error en la consulta Carrito");
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
