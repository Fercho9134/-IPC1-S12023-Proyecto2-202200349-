
package Clases;

import java.io.Serializable;

public class Categoria implements Serializable{
    
    private String nombreCategoria;
    private ListaImagenes imagenes;

    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.imagenes = new ListaImagenes();
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ListaImagenes getImagenes() {
        return imagenes;
    }

    public void setImagenes(ListaImagenes imagenes) {
        this.imagenes = imagenes;
    }
    
    
    
    
    
}
