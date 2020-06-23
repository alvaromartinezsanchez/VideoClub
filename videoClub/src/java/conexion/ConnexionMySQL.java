package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jspTag.*;        //Paquete que contiene la clase usuario

public class ConnexionMySQL {
    //Variable que usaremos para crear la conexión

    private Connection conn = null;
    //Debemos de poner el nombre de la base de datos, en nuestro caso pruebas
    private String dbName = "videoclubvm";
    //Debemos de poner el nombre del usuario, en nuestro caso root
    private String Nombre = "root";
    //Debemos de poner la contraseña de la base de datos, en nuestro caso no tiene
    private String pass = "";
    //Dirección completa donde se encuentra nuestra base de datos
    //Usamos la linea ?useSSL=false para no usar el protocolo SSL y que no nos muestre esa advertencia
    private String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";

    /* Método para obtener una conexión a la base de datos */
    public Connection obtenerConexion() {
        System.out.println(url);
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, Nombre, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /* Método para terminar la conexión a la base de datos */
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión");
        }
    }
    //Alquilar Pelicula--> Inserta en tabla reservas
    public void alquilarPelicula(int id_User, int id_Peli, String fecha, String estado, int precio, int descuento) {
        try {
            
            
            String sql2="UPDATE reservas SET estado='"+estado+"' WHERE Id_Pelicula='"+id_Peli+"' and Id_Usuario='"+id_User+"' and fecha='"+fecha+"'";
            PreparedStatement pst = conn.prepareStatement(sql2);
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //CAMBIAR DATOS USUARIO
    public void cambiarDatos(int id_User, String nombre, String direccion, String clave, String correo, String telefono) {
        try {
            
            String sql="UPDATE usuarios SET id='"+id_User+"' , nombre='"+nombre+"' , direccion='"+direccion+"' , clave='"+clave+"' , Correo='"+correo+"' , telefono='"+telefono+"' WHERE id='"+id_User+"' ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //CANCELAR RESERVA
    public void cancelarReserva(int id_User, int id_Peli, String fecha, String estado) {
        try {
            
            String sql="DELETE FROM reservas WHERE  Id_Usuario='"+id_User+"' AND Id_Pelicula='"+id_Peli+"' AND fecha='"+fecha+"' AND estado='"+estado+"' " ;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            
            String sql2="UPDATE peliculas SET Stock=Stock+1 WHERE Id_Pelicula='"+id_Peli+"' ";
             pst = conn.prepareStatement(sql2);
            pst.executeUpdate();
            
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //RESERVAR PELICULA
    public void reservarPelicula(int id_User, int id_Peli,String nombre, String imagen, String fecha, String estado, int precio, int descuento) {
        try {
            String sql = "INSERT INTO reservas (id_Usuario, id_Pelicula, Nombre, imagen, fecha, estado, precio, descuento) values (?,?,?,?,?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id_User);
            pst.setInt(2, id_Peli);
            pst.setString(3, nombre);
            pst.setString(4, imagen);
            pst.setString(5, fecha);
            pst.setString(6, estado);
            pst.setInt(7, precio);
            pst.setInt(8, descuento);
            pst.executeUpdate();
            
            String sql2="UPDATE peliculas SET Stock=Stock-1 WHERE Id_Pelicula='"+id_Peli+"' ";
             pst = conn.prepareStatement(sql2);
            pst.executeUpdate();
            
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //RESERVAR JUEGO
    public void reservarJuego(int id_User, int id_Peli,String nombre, String imagen, String fecha, String estado, int precio, int descuento) {
        try {
            String sql = "INSERT INTO reservas (id_Usuario, id_Pelicula, Nombre, imagen, fecha, estado, precio, descuento) values (?,?,?,?,?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id_User);
            pst.setInt(2, id_Peli);
            pst.setString(3, nombre);
            pst.setString(4, imagen);
            pst.setString(5, fecha);
            pst.setString(6, estado);
            pst.setInt(7, precio);
            pst.setInt(8, descuento);
            pst.executeUpdate();
            
            String sql2="UPDATE juegos SET Stock=Stock-1 WHERE Id_Juego='"+id_Peli+"' ";
             pst = conn.prepareStatement(sql2);
            pst.executeUpdate();
            
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Insertar Usuarios
    public void insertarDatos(int nif, String nombre, String direccion, String clave, String Correo, String telefono) {
        System.out.println(nif);
        System.out.println(nombre);
        System.out.println(direccion);
        System.out.println(clave);
        System.out.println(Correo);
        System.out.println(telefono);
        try {
            String sql = "INSERT INTO usuarios (id, nombre, direccion, clave, Correo, telefono) values (?,?,?,?,?,?);";
            System.out.println(sql);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, nif);
            pst.setString(2, nombre);
            pst.setString(3, direccion);
            pst.setString(4, clave);
            pst.setString(5, Correo);
            pst.setString(6, telefono);
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //MOSTRAR DATOS USUARIO
     public ResultSet mostrarUsuario(int idUsuario) {
		try {
			String sql ="select * from usuarios where id='"+idUsuario+"'";
			Statement st =conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;	
		} catch (SQLException e) {
			System.out.println("Error en la consulta mostrarUsuario");
                        return null;
		}


	}
    
    public ResultSet mostrar(int id_Peli) {
		try {
			String sql ="select * from peliculas where Id_Pelicula='"+id_Peli+"'";
			Statement st =conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;	
		} catch (SQLException e) {
			System.out.println("Error en la consulta mostrar");
                        return null;
		}


	}

    /* Método para comprobar su hay un usuario en la base de datos */
    public ResultSet comprobarUsuario(String nombre, String clave) {
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from usuarios WHERE nombre=? AND clave=?");
            pst.setString(1, nombre);
            pst.setString(2, clave);
            ResultSet miResultado = pst.executeQuery();
            return miResultado;
        } catch (SQLException e) {
            System.out.println("Error en la consulta comprobar usuario");
            return null;
        }

    }

    public ArrayList<usuario> listarUsuarios(int id) {
        ArrayList<usuario> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from usuarios where id='"+id+"'");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new usuario(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error en la consulta listar usuarios");
            return null;
        }
    }
    
    //Listar Reservas de USUARIO
    public ArrayList<reservas> listarReservas(int id_Usuario){
        ArrayList<reservas> reserva =new ArrayList<>();
        try {
            PreparedStatement consulta = conn.prepareStatement("select * from reservas where Id_Usuario='"+id_Usuario+"' and estado='Preparacion'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                reserva.add(new reservas(resultado.getInt(1),resultado.getInt(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getInt(7),resultado.getInt(8)));
            }
            return reserva;
        } catch (SQLException ex) {
            System.out.println("Error en consulta listarReservasUsuario");
            return null;
        }
    }
    //Listar HISTORIAL DE USUARIO
    public ArrayList<reservas> listarHistorico(int id_Usuario){
        ArrayList<reservas> reserva =new ArrayList<>();
        try {
            PreparedStatement consulta = conn.prepareStatement("select * from reservas where Id_Usuario='"+id_Usuario+"' and estado='Pagado'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                reserva.add(new reservas(resultado.getInt(1),resultado.getInt(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getInt(7),resultado.getInt(8)));
            }
            return reserva;
        } catch (SQLException ex) {
            System.out.println("Error en consulta historial de usuario");
            return null;
        }
    }
    //Listar HISTORIAL DE USUARIO RECIBIDOS
    public ArrayList<reservas> listarHistoricoRecibidos(int id_Usuario){
        ArrayList<reservas> reserva =new ArrayList<>();
        try {
            PreparedStatement consulta = conn.prepareStatement("select * from reservas where Id_Usuario='"+id_Usuario+"' and estado='Enviado'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                reserva.add(new reservas(resultado.getInt(1),resultado.getInt(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getInt(7),resultado.getInt(8)));
            }
            return reserva;
        } catch (SQLException ex) {
            System.out.println("Error en consulta listarHistorico recibidos");
            return null;
        }
    }
    //LISTAR RESERVAS  HISTORICO GENERAL
    public ArrayList<reservas> listarTodasReservas(){
        ArrayList<reservas> reserva =new ArrayList<>();
        try {
            PreparedStatement consulta = conn.prepareStatement("select * from reservas");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                reserva.add(new reservas(resultado.getInt(1),resultado.getInt(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getInt(7),resultado.getInt(8)));
            }
            return reserva;
        } catch (SQLException ex) {
            System.out.println("Error en consulta listarTodasReservas");
            return null;
        }
    }
    //LISTAR JUEGOS
    public ArrayList<juegos> listarJuegos() {
        ArrayList<juegos> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from juegos order by Descuento");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new juegos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error en la consulta listarjuegos");
            return null;
        }
    }
    
    //LISTAR JUEGOS GENERO
    public ArrayList<juegos> listarJuegosGenero(String creador) {
        ArrayList<juegos> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from juegos where Creador='"+creador+"' order by Descuento limit 8");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new juegos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error en la consulta listarjuegos");
            return null;
        }
    }
    
    //LISTAR PELICULAS FILTRO 8 CON MAYOR DESCUENTO
    public ArrayList<pelicula> listarPeliculasInicio() {
        ArrayList<pelicula> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from peliculas order by Descuento limit 8");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //LISTAR PELICULAS TODAS ORDENADAS POR DESCUENTO
    public ArrayList<pelicula> listarPeliculas() {
        ArrayList<pelicula> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from peliculas order by Descuento");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error en la consulta listarpeliculas");
            return null;
        }
    }
    public ArrayList<pelicula> listarPeliculasGenero(String genero) {
        ArrayList<pelicula> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from peliculas where Genero='"+genero+"' order by Descuento limit 8");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }

}
