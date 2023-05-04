package Clases;

import java.io.File;

public class JPEGImageCopy extends ImageHandler {

    protected String direccion;
    protected String nombre;

    public JPEGImageCopy(String nombre, String direccion) {
        super(nombre);
        this.direccion = direccion;
        this.nombre = nombre;
    }

    @Override
    public void readFile() throws Exception {
        System.out.println("Archivo JPG leído correctamente");
    }

    @Override
    public void generateFiles() throws Exception {

        //corregir
        String rutaTemporal = System.getProperty("user.home") + "\\Desktop\\Temporal\\";

        JPEGtoBMPHandler convertirABmp = new JPEGtoBMPHandler(false, nombre, direccion);
        convertirABmp.readFile();
        convertirABmp.generateFiles();

        File originalFile1 = new File(rutaTemporal + convertirABmp.obtenerNombre()); // archivo original en la raíz del directorio
        File newFile1 = new File(convertirABmp.obtenerNombre()); // archivo de destino en la carpeta "Temporal" del escritorio

        boolean success = originalFile1.renameTo(newFile1);
        if (!success) {
            System.out.println("No se pudo mover o renombrar el archivo.");
        }

        BmpHandlerCopy copiarBmp = new BmpHandlerCopy(convertirABmp.obtenerNombre());
        copiarBmp.readFile();
        copiarBmp.generateFiles();

        System.out.println("Aqui");
        BMPtoJPEGHandler convertirAJpg = new BMPtoJPEGHandler(false, copiarBmp.copyname, copiarBmp.copyname);
        convertirAJpg.readFile();
        System.out.println("Aqui 2");
        convertirAJpg.generateFiles();
        System.out.println("Aqui 3");

        this.nombre = convertirAJpg.obtenerNombre();

        String outputPath = System.getProperty("user.dir");
        File archivo = new File(outputPath + "/" + convertirABmp.obtenerNombre());
        File archivo1 = new File(outputPath + "/" + copiarBmp.copyname);
        archivo.delete();
        archivo1.delete();

    }

    public String obtenerNombre() {
        return this.nombre;
    }

}
