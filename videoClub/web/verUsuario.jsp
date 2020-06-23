<%-- 
    Document   : verUsuario
    Created on : 09-feb-2020, 19:30:40
    Author     : alvaro
--%>
<%@page import="jspTag.usuario"%>
<%@page import="java.util.ArrayList"%>
<%--Importamos Paquete Conexion y paquete para usar el resultset(resultado de las consultas)--%>
<%@page import="conexion.*" %>
<%@page import="java.sql.ResultSet" %>
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
            h4{color:white;}
            table{color:white; background: #222020e3;}
            form{color:white; background: #8156563d; padding: 5px; margin: 5px; border-raius:25px;}
        </style>
    </head>
    <body>


        <div class="container">
            <header class="row justify-content-center">
                <h1 class="col-10">Datos de Usuario</h1>
            </header>

            <section>
                <article class="row justify-content-center">
                    <form action="cambiarDatosUsuario" method="post" class="col-12">
                        <div class="row p-1 m-1">
                            <c:forEach var="UsuarioTemp" items="${UsuarioList}">
                                <div class="col-3">
                                    <div>Nombre</div>  
                                    <div>Contraseña:</div> 
                                    <div>Direccion C/-C.P-Poblacion-Region </div>
                                    <div>Correo</div>
                                    <div>Telefono</div> 
                                </div>
                                <div class="col-8">
                                    <input class="col-8" type="text" name="nombre" value="${UsuarioTemp.getNombre()}">
                                    <input class="col-8" type="text" name="clave" value="${UsuarioTemp.getClave()}">
                                    <input class="col-8" type="text" name="direccion" value="${UsuarioTemp.getDireccion()}">
                                    <input class="col-8" type="text" name="correo" value="${UsuarioTemp.getCorreo()}">
                                    <input class="col-8" type="text" name="telefono" value="${UsuarioTemp.getTelefono()}">
                                </div>
                                <div class="row mt-4">
                                    <p class="col-2"><input class="btn btn-outline-danger" type="submit" value="Enviar"> </p>
                                    <p class="col-5"><a class="btn btn-outline-primary" href="verHistoricoUsuario">Historico/Pendientes</a></p>
                                    <p class="col-4"><a class="btn btn-outline-success" href="cargaInicio">Ir a Inicio</a></p>
                                </div>
                                
                            </c:forEach>
                        </div>
                    </form>
                </article>
            </section>



        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
