/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Fernando
 */
public class JPEGImageHandlerBN extends ImageHandler {

    String nombre;
    String direccion;
    BufferedImage bmpOriginal;

    public JPEGImageHandlerBN(String nombre, String direccion) {
        super(nombre);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public void readFile() throws Exception {
        this.bmpOriginal = ImageIO.read(new File(direccion));
        this.nombre = "BN-" + nombre.replace("bmp", "jpg");
    }

    @Override
    public void generateFiles() throws Exception {
        int width = bmpOriginal.getWidth();
        int height = bmpOriginal.getHeight();

        // Creamos una nueva imagen en blanco y negro del mismo tamaño que la original
        BufferedImage imgBN = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Recorremos la imagen original y asignamos el color correspondiente a cada píxel de la imagen en blanco y negro
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = bmpOriginal.getRGB(x, y);
                int r = (pixel >> 16) & 0xFF; // Componente rojo
                int g = (pixel >> 8) & 0xFF; // Componente verde
                int b = pixel & 0xFF; // Componente azul

                // Calculamos el promedio de los componentes de color y creamos un nuevo píxel en escala de grises
                int promedio = (r + g + b) / 3;
                int nuevoPixel = (promedio << 16) | (promedio << 8) | promedio;

                // Asignamos el nuevo píxel a la imagen en blanco y negro
                imgBN.setRGB(x, y, nuevoPixel);
            }
        }

        
        String direccionTempo = System.getProperty("user.home") + "/Desktop/Temporal/";
        // Guardamos la imagen en blanco y negro en un archivo JPEG
        File archivoBN = new File(direccionTempo + nombre);
        ImageIO.write(imgBN, "jpg", archivoBN);
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }

}
