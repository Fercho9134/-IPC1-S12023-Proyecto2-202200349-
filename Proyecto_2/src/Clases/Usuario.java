package Clases;

import java.io.Serializable;
import java.util.ArrayList;


public class Usuario implements Serializable{
    
  private int indiceUsuario;
  private static int indiceContador=0;
  private String nombreUsuario;
  private ArrayList<Categoria> categorias;

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.categorias = new ArrayList<>();
        categorias.add(new Categoria("General"));
        this.indiceUsuario = indiceContador;
        indiceContador++;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public int getIndiceUsuario() {
        return indiceUsuario;
    }
    
    
  
    
    
  
  
}
