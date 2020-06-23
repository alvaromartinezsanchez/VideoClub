<%-- 
    Document   : Carrito
    Created on : 11-feb-2020, 18:04:25
    Author     : alvaro
--%>

<%@page import="jspTag.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="conexion.ConnexionMySQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            body { background-image: url(./img/fondo.jpg); }
            header{ background-color: black; color: white; border-radius: 10px; border: 1px solid grey; margin-top: 5px; margin-bottom: 45px; padding:15px; text-align: center;}
            h2, h4{color:white;}
            table{color:white; background: #222020e3;}
            footer{ color:white; background:#272b273a;}
        </style>
    </head>
    <body>


        <div class="container">
            <header>
                <h2 class="col-8">Reserva de articulos en preparacion</h2>
            </header>

            <section>
                <article class="row justify-content-center">
                    
                    <div class="col-8">
                        <h4>Carrito</h4>
                        <table class="text-center p-4 m-3 col-12">
                            <tr>
                                <th>Articulo</th>
                                <th>Fecha Reserva</th>
                                <th>Precio</th>
                                <th>Descuento</th>
                                <th>Estado</th>
                                <th>Alquilar</th>
                                <th>Cancelar</th>
                            </tr>
                            <c:forEach var="ReservasTemp" items="${lasReservas}">
                                <tr>

                                    <td> ${ReservasTemp.getNombre()} </td>
                                    <td> ${ReservasTemp.getFecha()} </td>
                                    <td> ${ReservasTemp.getPrecio()} </td>
                                    <td> ${ReservasTemp.getDescuento()}% </td>
                                    <td> ${ReservasTemp.getEstado()} </td>
                                    <td><a class="btn btn-outline-success" href="alquilarPelicula?id=${ReservasTemp.getId_Pelicula()}&fecha=${ReservasTemp.getFecha()}">Alquilar</a></td>
                                    <td><a class="btn btn-outline-danger" href="cancelarPelicula?id=${ReservasTemp.getId_Pelicula()}&fecha=${ReservasTemp.getFecha()}">Cancelar</a></td>
                                </tr>
                            </c:forEach> 
                            <tr>
                                <td><a class="btn btn-outline-primary" href="cargaInicio">Ir a Inicio</a></td>
                            </tr>
                        </table>

                    </div>    

                </article>
            </section>

        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
