<%-- 
    Document   : NumeroCuenta
    Created on : 21-feb-2020, 20:36:12
    Author     : alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body { background-image: url(./img/fondo.jpg); }
            header{ background-color: black; color: white; border-radius: 10px; border: 1px solid grey; margin-top: 5px; margin-bottom: 45px; padding:15px; text-align: center;}
            h1{color:white;}
            .btn:hover{ background: dimgrey;}
            .btn{color:white; background: grey;}
            table{color:white; background: #222020e3;}
            form{color:white; background: #8156563d; padding: 5px; margin: 5px; border-raius:25px;}
        </style>
    </head>
    <body>
        <% 
            
        %>
        <h1>Introduce tu numero de cuenta para poder realizar las compras</h1>
        <form method="post" action="cargaCarrito">
            <input type="text" placeholder="IVAN 1323548210" required>
            <input type="submit" value="continuar">
        </form>
    <c:forEach var="UsuarioTemp" items="${UsuarioList2}">
        <h4>${UsuarioTemp.getNombre()} tus compras se enviaran a la siguiente direccion:</h4>
        <h4>${UsuarioTemp.getDireccion()}</h4>
    </c:forEach>
    </body>
</html>
