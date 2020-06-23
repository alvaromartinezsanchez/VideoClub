<%-- 
    Document   : HistoricoUsuario
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
            h1,h2,h4{color:white;}
            
            table{color:white; background: #222020e3; }
            form{color:white; background: #8156563d; padding: 5px; margin: 5px; border-raius:5px;}
            small{font-size: 10px; color:grey;}
        </style>
    </head>
    <body>
       

        <div class="container">
            <header>
                <h2 class="col-12">Historico Usuario</h2>
            </header>

            <section>
                <article class="row">
                    
                    <div class="col-8 p-3">
                        <h4>Pendientes<small class="text-mutted">A la espera de marcar como recibido para cambiar a estado enviado</small></h4>
                            <table class="text-center p-2 m-2 col-12" border="1">
                                <tr class="mb-5">
                                    
                                    <th>Articulo</th>
                                    <th>Fecha</th>
                                    <th>Estado</th>
                                    <th>Recibido</th>
                                </tr>
                                <c:forEach var="PagadosTemp" items="${Pagados}">
                                    <tr>
                                        <td> ${PagadosTemp.getNombre()} </td>
                                        <td> ${PagadosTemp.getFecha()} </td>
                                        <td> ${PagadosTemp.getEstado()} </td>
                                        <td> ${PagadosTemp.getPrecio()} </td>
                                        <td><a class="btn btn-outline-danger" href="RecibePelicula?id=${PagadosTemp.getId_Pelicula()}&fecha=${PagadosTemp.getFecha()}">Recibida</a></td>
                                    </tr>
                                </c:forEach> 
                                    <tr>
                                        <td><a class="btn btn-outline-primary" href="datosUsuario">Ir a Usuario</a></td>
                                    </tr>
                            </table>
                        
                    </div>    

                </article>
                
                <article class="row">
                    <div class="col-8">
                        <h4>Recibidos<small class="text-mutted">Estado enviado</small></h4>
                            <table class="text-center p-2 m-2 col-12" border="1">
                                <tr>
                                    
                                    <th>Articulo</th>
                                    <th>Fecha</th>
                                    <th>Estado</th>
                                    <th>Recibido</th>
                                </tr>
                                <c:forEach var="RecibidosTemp" items="${Recibidos}">
                                    <tr>
                                        <td> ${RecibidosTemp.getNombre()} </td>
                                        <td> ${RecibidosTemp.getFecha()} </td>
                                        <td> ${RecibidosTemp.getEstado()} </td>
                                        <td> ${RecibidosTemp.getPrecio()} </td>
                                    </tr>
                                </c:forEach> 
                                    <tr>
                                        <td><a class="btn btn-outline-primary" href="datosUsuario">Ir a Usuario</a></td>
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
