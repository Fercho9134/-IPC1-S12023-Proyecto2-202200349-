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
public class Nodo implements Serializable{
    
    private int indice;
    private Object usuario;
    public Nodo siguiente;
    
    public Nodo(Object usuario, int indice){
        this.indice = indice;
        this.usuario = usuario;
        this.siguiente = null;
    }

    public Object getUsuario() {
        return usuario;
    }

    public void setUsuario(Object usuario) {
        this.usuario = usuario;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
    
    
    
}
