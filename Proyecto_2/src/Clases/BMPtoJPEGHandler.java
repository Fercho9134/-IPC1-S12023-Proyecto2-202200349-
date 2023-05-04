package Clases;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BMPtoJPEGHandler extends ImageHandler {
    
    protected String direccion;
    protected String nombre;
    protected BufferedImage bmpImage, jpegImage;
    protected boolean copia;
    
    public BMPtoJPEGHandler(boolean copia, String nombre, String direccion) {
        super(nombre);
        this.direccion = direccion;
        this.copia = copia;
        this.nombre = nombre;
    }

    @Override
    public void readFile() throws Exception {
        this.bmpImage = ImageIO.read(new File(direccion));
        nombre = nombre.replace("bmp", "jpg");
        System.out.println("Imagen leida en bmp a jpg");
    }
    
    @Override
    public void generateFiles() throws Exception {
       
        // Convierte la imagen BMP a JPEG
        jpegImage = new BufferedImage(bmpImage.getWidth(), bmpImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        jpegImage.createGraphics().drawImage(bmpImage, 0, 0, null);

        // Escribe la imagen JPEG a disco
        String outputPath = System.getProperty("user.home") + "/Desktop/Temporal/";
        if (this.copia) {
            nombre = "converted-" + nombre;
        }

        File jpegFile = new File(outputPath + nombre);
        ImageIO.write(jpegImage, "jpg", jpegFile);


        System.out.println("JPEG generado: " + nombre);
    }
    
    public void eliminarImagen(){
        // Elimina la imagen JPEG convertida si solo se utilizó para realizar algun proceso
            String outputPath = System.getProperty("user.home") + "/Desktop/Temporal/";
            File archivo = new File(outputPath + "/" + this.nombre);
            archivo.delete();
        
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }
    
    
}
