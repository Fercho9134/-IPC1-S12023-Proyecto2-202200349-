package Clases;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class JPEGtoBMPHandler extends ImageHandler {

    protected String direccion;
    protected String nombre;
    protected BufferedImage jpegImage, bmpImage;
    protected boolean copia;

    public JPEGtoBMPHandler(boolean copia, String nombre, String direccion) {
        super(nombre);
        this.direccion = direccion;
        this.nombre = nombre;
        this.copia = copia;
    }
    

    @Override
    public void readFile() throws Exception {
        this.jpegImage = ImageIO.read(new File(direccion));
        nombre = nombre.replace("jpg", "bmp")
                .replace("jpeg", "bmp")
                .replace("JPEG", "bmp")
                .replace("JPG", "bmp");

    }

    @Override
    public void generateFiles() throws Exception {
        // Create BMP file
        bmpImage = new BufferedImage(this.jpegImage.getWidth(), jpegImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        bmpImage.createGraphics().drawImage(jpegImage, 0, 0, null);

        // Write BMP file to disk
        String outputPath = System.getProperty("user.home") + "/Desktop/Temporal/";
        if (this.copia) {
            nombre = "converted-" + nombre;
        }

        File bmpFile = new File(outputPath + this.nombre);
        ImageIO.write(bmpImage, "bmp", bmpFile);

        System.out.println("BMP generado: " + nombre);
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void eliminarImagen() {
        String outputPath = System.getProperty("user.home") + "/Desktop/Temporal/";
        File archivo = new File(outputPath + "/" + this.nombre);
        archivo.delete();
    }

}
