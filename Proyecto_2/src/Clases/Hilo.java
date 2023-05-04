/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Vistas.Convertidor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class Hilo implements Runnable{

    String nombre;
    String direccion;
    boolean jpgABmp,copiaJpg, rgb, modificar, blancoNegro;
    Convertidor convertidor;
    int tiempo;
    NodoDoble nodo;

    public Hilo(String nombre, String direccion, boolean jpgABmp, boolean copiaJpg, boolean rgb, boolean modificar, boolean blancoNegro, Convertidor convertidor, int tiempo, NodoDoble nodo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.jpgABmp = jpgABmp;
        this.copiaJpg = copiaJpg;
        this.rgb = rgb;
        this.modificar = modificar;
        this.blancoNegro = blancoNegro;
        this.convertidor = convertidor;
        this.tiempo = tiempo;
        this.nodo = nodo;
    }
    
    
    
    @Override
    public void run() {
        try {
            
        
        if(jpgABmp){
            Thread.sleep(200*tiempo);
            JPEGtoBMPHandler handler = new JPEGtoBMPHandler(true,nombre,direccion);
            try {
                convertidor.agregarTextoConsola(this.nombre + " fue leído");
                handler.readFile();
                handler.generateFiles();
                convertidor.agregarTextoConsola(this.nombre + " fue convertido a BMP exitosamente");
                convertidor.barra(convertidor.incrementoBarra);
                convertidor.cantidadProcesada = convertidor.cantidadProcesada +1;
            } catch (Exception ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(copiaJpg){
            Thread.sleep(200*tiempo);
            JPEGImageCopy handler = new JPEGImageCopy(nombre,direccion);
            try {
                convertidor.agregarTextoConsola(this.nombre + " fue leído");
                handler.readFile();
                handler.generateFiles();
                convertidor.agregarTextoConsola(this.nombre + " fue copiado exitosamente");
                convertidor.barra(convertidor.incrementoBarra);
                convertidor.cantidadProcesada = convertidor.cantidadProcesada +1;
            } catch (Exception ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(rgb){
            Thread.sleep(200*tiempo);
            JPEGImageHandlerColors handler = new JPEGImageHandlerColors(nombre,direccion);
            try {
                convertidor.agregarTextoConsola(this.nombre + " fue leído");
                handler.readFile();
                handler.generateFiles();
                convertidor.agregarTextoConsola(this.nombre + " fue separado en colores exitosamente");
                convertidor.barra(convertidor.incrementoBarra);
                convertidor.cantidadProcesada = convertidor.cantidadProcesada +1;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        
        if(modificar){
            Thread.sleep(200*tiempo);
            JPEGImageHandlerRotator handler = new JPEGImageHandlerRotator(nombre,direccion);
            try {
                convertidor.agregarTextoConsola(this.nombre + " fue leído");
                handler.readFile();
                handler.generateFiles();
                convertidor.agregarTextoConsola(this.nombre + " fue rotado exitosamente");
                convertidor.barra(convertidor.incrementoBarra);
                convertidor.cantidadProcesada = convertidor.cantidadProcesada +1;
            } catch (Exception ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        

        if(blancoNegro){
            Thread.sleep(200*tiempo);
            JPEGImageHandlerBN handler = new JPEGImageHandlerBN(nombre,direccion);
            try {
                convertidor.agregarTextoConsola(this.nombre + " fue leído");
                handler.readFile();
                handler.generateFiles();
                convertidor.agregarTextoConsola(this.nombre + " fue convertido a blanco y negro exitosamente");
                convertidor.barra(convertidor.incrementoBarra);
                convertidor.cantidadProcesada = convertidor.cantidadProcesada +1;
            } catch (Exception ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        convertidor.borrarElementoCola(nodo);
        convertidor.actualizarColaProcesamiento();
        if(convertidor.cantidadProcesada==convertidor.total){
            convertidor.llenarBarra();
        }
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    
}
