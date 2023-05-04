package Clases;

import java.awt.image.BufferedImage;

public class Imagen {

    private BufferedImage imagen;
    private String nombre;
    private String direccion;
    private int codigoImagen;
    private static int contador =0;
    
    public Imagen(BufferedImage imagen, String nombre, String direccion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigoImagen = contador;
        contador++;
    }

    public int getCodigoImagen() {
        return codigoImagen;
    }

    public void setCodigoImagen(int codigoImagen) {
        this.codigoImagen = codigoImagen;
    }
    
    

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Métodos adicionales para manipular la imagen...
}
