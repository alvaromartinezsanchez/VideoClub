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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jspTag.pelicula;

/**
 *
 * @author alvaro
 */
public class compruebaUsuario extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            String nombre = request.getParameter("nombre");
            String clave = request.getParameter("clave");

            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            ResultSet miResultado = cn.comprobarUsuario(nombre, clave);
            if (miResultado.absolute(1)) {
                int id = miResultado.getInt(1);
                String nombreUs = miResultado.getString(2);
                String direccion=miResultado.getString(3);
                String nombreUsuario = "nombreUsuario";
                String id_Usuario = "id_Usuario";
                String direccionUsu="direccionUsuario";
                // Creamos la sesión, si no estaba creada.
                HttpSession session = request.getSession(true);
                
                session.setAttribute("direccionUsu", direccion);
                session.setAttribute("id_Usuario", id);
                session.setAttribute("nombreUsuario", nombreUs);
                out.print(session.getAttribute(id_Usuario));
                
                //Cargamos lista de peliculas para enviar a inicio
                ArrayList<pelicula> datosPelicula = new ArrayList<>();
                request.setCharacterEncoding("UTF-8");
                cn.obtenerConexion();
                datosPelicula = cn.listarPeliculasInicio();
                
                
                //Incluyo la lista de peliculas en la respuesta
                request.setAttribute("lasPeliculas", datosPelicula);
                
                //Preparamos para enviar a Inicio.jsp
                RequestDispatcher myDispatcher = request.getRequestDispatcher("./Inicio.jsp");
                
                //Envio
                myDispatcher.forward(request, response);
                cn.desconectar();
            } else {
                response.sendRedirect("registrarUsuarios.jsp");
            }
            cn.desconectar();

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(compruebaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(compruebaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(compruebaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(compruebaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
