package jspTag;

public class pelicula {
    private int Id_Pelicula;
    private String Nombre;
    private String Director;
    private String Sinopsis;
    private String Imagen;
    private int Stock;
    private String Ano;
    private String Genero;
    private int Precio;
    private int Descuento;

    public pelicula(int Id_Pelicula, String Nombre, String Director, String Sinopsis, String Imagen, int Stock, String Ano, String Genero, int Precio, int Descuento) {
        this.Id_Pelicula = Id_Pelicula;
        this.Nombre = Nombre;
        this.Director = Director;
        this.Sinopsis = Sinopsis;
        this.Imagen = Imagen;
        this.Stock = Stock;
        this.Ano = Ano;
        this.Genero = Genero;
        this.Precio = Precio;
        this.Descuento = Descuento;
    }

    public int getId_Pelicula() {
        return Id_Pelicula;
    }

    public void setId_Pelicula(int Id_Pelicula) {
        this.Id_Pelicula = Id_Pelicula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String Sinopsis) {
        this.Sinopsis = Sinopsis;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    
    public void descontar() {
        this.Stock = Stock-1;
    }
    public void aumentar() {
        this.Stock = this.Stock+1;
    }

    
    
    
}
