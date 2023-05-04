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
public class JPEGImageHandlerColors extends ImageHandler {

    String nombre;
    String direccion;
    BufferedImage bmpOriginal;
    String nombreAzul;
    String nombreVerde;
    String nombreRojo;
    String nombreSepia;

    public JPEGImageHandlerColors(String nombre, String direccion) {
        super(nombre);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public void readFile() throws Exception {
        this.bmpOriginal = ImageIO.read(new File(direccion));
        nombreAzul = "Blue-" + nombre.replace("bmp", "jpg");
        nombreVerde = "Green-" + nombre.replace("bmp", "jpg");
        nombreRojo = "Red-" + nombre.replace("bmp", "jpg");
        nombreSepia = "Sepia-" + nombre.replace("bmp", "jpg");

    }

    @Override
    public void generateFiles() throws Exception {
        // Obtener las dimensiones de la imagen original
        int width = bmpOriginal.getWidth();
        int height = bmpOriginal.getHeight();

        // Crear cuatro nuevas imágenes con las mismas dimensiones que la original
        BufferedImage imgAzul = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage imgVerde = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage imgRojo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage imgSepia = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Generar las cuatro imágenes
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = bmpOriginal.getRGB(x, y);
                int r = (pixel >> 16) & 0xFF; // Componente rojo
                int g = (pixel >> 8) & 0xFF; // Componente verde
                int b = pixel & 0xFF; // Componente azul

                // Imagen con tonos azules
                imgAzul.setRGB(x, y, (b << 16) | (b << 8) | 200);
                // Imagen con tonos verdes
                imgVerde.setRGB(x, y, (0 << 16) | (g << 8) | 0);
                // Imagen con tonos rojos
                imgRojo.setRGB(x, y, (r << 16) | (0 << 8) | 0);
                // Imagen con tonos sepia
                int sepiaR = (int) (0.393 * r + 0.769 * g + 0.189 * b);
                int sepiaG = (int) (0.349 * r + 0.686 * g + 0.168 * b);
                int sepiaB = (int) (0.272 * r + 0.534 * g + 0.131 * b);
                sepiaR = Math.min(255, sepiaR);
                sepiaG = Math.min(255, sepiaG);
                sepiaB = Math.min(255, sepiaB);
                imgSepia.setRGB(x, y, (sepiaR << 16) | (sepiaG << 8) | sepiaB);
            }
        }

        String direccionTempo = System.getProperty("user.home") + "/Desktop/Temporal/";

        // Guardar las cuatro imágenes generadas
        File azulFile = new File(direccionTempo + nombreAzul);
        ImageIO.write(imgAzul, "jpg", azulFile);
        File verdeFile = new File(direccionTempo + nombreVerde);
        ImageIO.write(imgVerde, "jpg", verdeFile);
        File rojoFile = new File(direccionTempo + nombreRojo);
        ImageIO.write(imgRojo, "jpg", rojoFile);
        File sepiaFile = new File(direccionTempo + nombreSepia);
        ImageIO.write(imgSepia, "jpg", sepiaFile);

        
    }
    
    public String obtenerNombre(){
        return this.nombreAzul;
    }

}
