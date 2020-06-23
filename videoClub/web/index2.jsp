
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/myStyles.css">
        <title>Práctica MVC</title>
        <style>
            body { background-image: url(./img/fondo.jpg); color:white;}
        </style>
        
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center my-5">
                <div class="col-6 border py-5">
                    <form action="compruebaUsuario" method="post">
                        <div class="row justify-content-center mb-5">
                            <h4 class="col-6">Inicio de Sesion</h4>
                        </div>
                        <div class="row mb-2">
                            <label class="col-3">Nombre</label>
                            <input class="col-8" type="text" name="nombre" required>
                        </div>
                        <div class="row">
                            <label class="col-3">Contraseña</label>
                            <input class="col-8" type="text" name="clave" required> 
                        </div>
                        <input type="submit" class="col-2 btn btn-outline-primary my-2" value="Aceptar">
                    </form>
                </div>
            </div>
            
           
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
