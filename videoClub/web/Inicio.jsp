<%-- 
    Document   : Inicio
    Created on : 08-feb-2020, 19:45:23
    Author     : alvaro
--%>
<%@page import="java.lang.NullPointerException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="Servlets.*" %>
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
        .btn:hover{ background: dimgrey; color:white;}
        .btn{color:white; background: black;}
        footer{ color:white; background:#272b273a;}
    </style>
    <body>

        <div class="container">
            <header class="row justify-content-center">

                <!--TITULO-->
                <div class="col-10">
                    <h2 class="text-center">VideClub-VM</h2>
                </div>

                <!--BARRA DE MENU-->

                <ul class="nav nav-pills nav-fill">
                    <li class="nav-item">
                        <a class="btn col" href="cargaPeliculas"  role="button"  class="nav-link active">Peliculas</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn col" href="cargaJuego"  role="button" >VideoJuegos</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn col" href="datosUsuario" role="button" class="nav-link active">Usuario Datos</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn col" href="cargaNumCuenta" role="button" class="nav-link active">Carrito</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn col" href="verHistorico" role="button" class="nav-link active">Historico</a>
                    </li>
                </ul>
            </header>
            <section>

                <article class="row justify-content-center">
                    <h4 class="col-12">Peliculas con mayor descuento:</h4>
                    <c:forEach var="PeliculasTemp" items="${lasPeliculas}">

                        <img class="col-2 m-4 " src=${PeliculasTemp.getImagen()};> 

                    </c:forEach>
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
