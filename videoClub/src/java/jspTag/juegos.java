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
public class juegos {
    private int Id_Juego;
    private String Nombre;
    private String Creador;
    private String Tipo;
    private int Precio;
    private int Stock;
    private int Descuento;
    private String Imagen;

    public juegos(int Id_Juego, String Nombre, String Creador, String Tipo, int Precio, int Stock, int Descuento, String Imagen) {
        this.Id_Juego = Id_Juego;
        this.Nombre = Nombre;
        this.Creador = Creador;
        this.Tipo = Tipo;
        this.Precio = Precio;
        this.Stock = Stock;
        this.Descuento = Descuento;
        this.Imagen = Imagen;
    }

    public int getId_Juego() {
        return Id_Juego;
    }

    public void setId_Juego(int Id_Juego) {
        this.Id_Juego = Id_Juego;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCreador() {
        return Creador;
    }

    public void setCreador(String Creador) {
        this.Creador = Creador;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    

    @Override
    public String toString() {
        return "juegos{" + "Id_Juego=" + Id_Juego + ", Nombre=" + Nombre + ", Creador=" + Creador + ", Tipo=" + Tipo + ", Precio=" + Precio + ", Stock=" + Stock + ", Descuento=" + Descuento + ", Imagen=" + Imagen + "" +  + '}';
    }

    
    
    
}
