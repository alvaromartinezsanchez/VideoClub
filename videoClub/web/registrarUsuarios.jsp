
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
        <div class="container">
            <div class="row">
                <div class="col-12"><h1>Registro de Usuario</h1></div>
                <form action="registrarUsuario" class="col-6" method="post">
                    <div class="form-group">
                        <label for="nif">Nif</label>
                        <input type="text" name="nif" id="" class="form-control" placeholder="Nif">
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" id="" class="form-control" placeholder="Nombre">
                    </div>
                    <div class="form-group">
                        <label for="direccion">Direccion</label>
                        <input type="text" name="direccion" id="" class="form-control" placeholder="Direccion C/ Nº C.P Poblacion">
                    </div>
                    <div class="form-group">
                        <label for="clave">Contraseña</label>
                        <input type="text" name="clave" id="" class="form-control" placeholder="Contraseña">
                    </div>
                    <div class="form-group">
                        <label for="Correo">Correo</label>
                        <input type="text" name="Correo" id="" class="form-control" placeholder="Correo">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="text" name="telefono" id="" class="form-control" placeholder="Telefono">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary">
                </form>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
