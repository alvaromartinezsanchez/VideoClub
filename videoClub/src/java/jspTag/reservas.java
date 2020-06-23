/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspTag;

/**
 *
 * @author alvaro
 */
public class reservas {
    private int Id_Usuario;
    private int Id_Pelicula;
    private String Nombre;
    private String imagen;
    private String fecha;
    private String estado;
    private int precio;
    private int descuento;

    public reservas(int Id_Usuario, int Id_Pelicula, String Nombre, String imagen, String fecha, String estado, int precio, int descuento) {
        this.Id_Usuario = Id_Usuario;
        this.Id_Pelicula = Id_Pelicula;
        this.Nombre = Nombre;
        this.imagen = imagen;
        this.fecha = fecha;
        this.estado = estado;
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

    public reservas(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public int getId_Pelicula() {
        return Id_Pelicula;
    }

    public void setId_Pelicula(int Id_Pelicula) {
        this.Id_Pelicula = Id_Pelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "reservas{" + "Id_Usuario=" + Id_Usuario + ", Id_Pelicula=" + Id_Pelicula + ", fecha=" + fecha + ", estado=" + estado + ", precio=" + precio + ", descuento=" + descuento + '}';
    }
    
    
}
