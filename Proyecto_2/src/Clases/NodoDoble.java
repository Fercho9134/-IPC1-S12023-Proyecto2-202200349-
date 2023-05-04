/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Fernando
 */
public class NodoDoble implements Serializable{
    
    private int indice;
    public NodoDoble siguiente;
    public NodoDoble anterior;
    Object imagen;
    
    public NodoDoble(Object imagen, int indice,NodoDoble siguiente, NodoDoble anterior){
        this.indice = indice;
        this.siguiente = siguiente;
        this.anterior = anterior;
        this.imagen = imagen;
    }
   

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Object getImagen() {
        return imagen;
    }

    public void setImagen(Object imagen) {
        this.imagen = imagen;
    }
    
    
}
