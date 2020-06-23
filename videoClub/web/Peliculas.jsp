<%-- 
    Document   : Peliculas
    Created on : 09-feb-2020, 12:35:08
    Author     : alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="jspTag.*" %>
<%@page import="conexion.ConnexionMySQL" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body { background-image: url(./img/fondo.jpg); }
        header{ background-color: black; color: white; border-radius: 10px; border: 1px solid grey; margin-top: 5px; margin-bottom: 45px; padding:15px; text-align: center;}
        h4{color:white;}
        .btn:hover{ background: #4b68473a; color:green;}
        .btn{color:white; }
        table{color:white; background: #222020e3;}
    </style>
    <body>
       <%
            

        %>
        <div class="container">
            <header class="row justify-content-center">

                <!--TITULO-->
                <div class="col-10">
                    <h2 class="text-center">VideClub-VM</h2>
                </div>

                <!--BARRA DE MENU-->
                <ul class="nav nav-pills nav-fill">
                    <li class="nav-item">
                        <a class="btn col" href="cargaInicio"  role="button"  class="nav-link active">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn col" href="cargaJuego"  role="button" >VideoJuegos</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn col" href="cargaNumCuenta" role="button" class="nav-link active">Carrito</a>
                    </li>
                </ul>
                
            </header>
            <section>
                
                    <article>
                        <form method="post" action="FiltroPeliculas" class="col-12">
                            
                            <select name="genero" onChange="submit()" >
                                <option value="Todos" selected>Genero</option>
                                <option value="Comedia">Comedia</option>
                                <option value="Ciencia Ficcion">Ciencia Ficcion</option>
                                <option value="Terror">Terror</option>
                                <option value="Accion">Accion</option>
                            </select>
                            <a class="btn btn-ligth-success" href="cargaPeliculas" role="button">Quitar Filtro</a>
                            <table border="1" class="text-center" p-2 m-2>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Stock</th>
                                    <th>Imagen</th>
                                    <th>Sinopsis</th>
                                    <th></th>
                                </tr>
                            <c:forEach var="PeliculasTemp" items="${lasPeliculas}">
                                <c:if test="${PeliculasTemp.getStock()>'0'}">
                                <tr>
                                    <td class="text-center"> ${PeliculasTemp.getNombre()} </td>
                                    <td> ${PeliculasTemp.getStock()} </td>
                                    <td><img src=${PeliculasTemp.getImagen()}; height="150px" width="150px"> </td>
                                    <td> ${PeliculasTemp.getSinopsis()} </td>
                                    <td><a  class="btn btn-outline-success" href="reservarPelicula?id=${PeliculasTemp.getId_Pelicula()}&imagen=${PeliculasTemp.getImagen()}&nomPeli=${PeliculasTemp.getNombre()}">añadir</a></td>
                                </tr>
                                </c:if>
                            </c:forEach>

                        </table>
                    </form>
                </article>  
            </section>
            <footer class="row justify-content-around align-item-center">
                <div class="col-6 col-md-8 align-self-center">
                    <div class="row align-item-center">
                        <img src="./img/logo.png" class="col-6 col-sm-4 col-md-2" style="width:50px; height: 50px;" alt="">
                        <h5 class="d-none d-md-block col-10 align-self-end">Derechos reservados © Ces-VegaMedia</h5>
                    </div>
                </div>
                <div class="col-6 col-md-3 align-self-center">
                    <div class="row justify-content-center align-item-center p-1">
                        <a href="" ><img class="col-12" style="width:100%; height: 100%;" src="./img/facebook.png" alt=""></a>
                        <a href="" ><img class="col-12" src="./img/twitte.jpg" alt=""></a>
                    </div>
                </div>
            </footer>
        </div>
        
         <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
