package Clases;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Fernando
 */
public class JPEGImageHandlerRotator extends ImageHandler{
    
    String nombre;
    String direccion;
    BufferedImage bmpOriginal;
    String nombreHorizontal;
    String nombreVertical;
    BufferedImage hRotation,vRotation;

    public JPEGImageHandlerRotator(String nombre, String direccion) {
        super(nombre);
        this.nombre = nombre;
        this.direccion = direccion;
                
    }

    @Override
    public void readFile() throws Exception {
        this.bmpOriginal = ImageIO.read(new File(direccion));
        hRotation = new BufferedImage(bmpOriginal.getWidth(), bmpOriginal.getHeight(), bmpOriginal.getType());
        vRotation = new BufferedImage(bmpOriginal.getWidth(), bmpOriginal.getHeight(), bmpOriginal.getType());
        nombreHorizontal = "Hrotation-" + nombre.replace("bmp", "jpg");
        nombreVertical = "Vrotation-" + nombre.replace("bmp", "jpg");
    }

    @Override
    public void generateFiles() throws Exception {
        
        String direccionTempo = System.getProperty("user.home") + "/Desktop/Temporal/";
        
        horizontalRotation();
        verticalRotation();
        
        File file = new File(direccionTempo+nombreHorizontal);
        ImageIO.write(vRotation, "jpg", file);
        
        File file2 = new File(direccionTempo+nombreVertical);
        ImageIO.write(hRotation, "jpg", file2);
        
    }
    
    
    private void horizontalRotation() {
    int width = bmpOriginal.getWidth();
    int height = bmpOriginal.getHeight();
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            hRotation.setRGB(x, y, bmpOriginal.getRGB(width - 1 - x, y));
        }
    }
    }
    
    private void verticalRotation() {
    int width = bmpOriginal.getWidth();
    int height = bmpOriginal.getHeight();
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            vRotation.setRGB(x, y, bmpOriginal.getRGB(x, height - 1 - y));
        }
    }
    }
    public String obtenerNombre(){
        return this.nombreHorizontal;
    }

   
    
    
}
