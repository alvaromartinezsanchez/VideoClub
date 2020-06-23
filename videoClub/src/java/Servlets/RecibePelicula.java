/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import conexion.ConnexionMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alvaro
 */
public class RecibePelicula extends HttpServlet {

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
            // Creamos la sesión, si no estaba creada.
            HttpSession session = request.getSession(true);
            request.setCharacterEncoding("UTF-8");
            Integer id_Peli = new Integer(request.getParameter("id"));
            String fecha=request.getParameter("fecha");
            int id_Us = (Integer) session.getAttribute("id_Usuario");
            out.print(id_Peli);
            out.print(id_Us);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                ConnexionMySQL cn = new ConnexionMySQL();
                cn.obtenerConexion();
                
                //Obtenemos la pelicula por su id
                ResultSet peli = cn.mostrar(id_Peli);
                
                //Creamos variables de la reserva
                String estado = "Enviado";
                int precio = 0;
                int descuento = 0;
                while (peli.next()) {
                    precio = peli.getInt(9);
                    descuento = peli.getInt(10);
                }
                cn.alquilarPelicula(id_Us, id_Peli, fecha, estado, precio, descuento);
                out.print("Id_US" + id_Us + "id-peli" + id_Peli + "fecha" + fecha + "estado" + estado + "precio" + precio + "descuento" + descuento);
                cn.desconectar();
                response.sendRedirect("verHistoricoUsuario");

            } catch (Exception e) {
                out.print("Fallo en la insercion..!!");
                e.printStackTrace();
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
