package Clases;

import Vistas.Principal;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Principal principal = new Principal();
        principal.setVisible(true);

        String escritorio = System.getProperty("user.home") + "/Desktop";

        File carpetaTemporal = new File(escritorio + "/Temporal");

        if (!carpetaTemporal.exists()) {

            boolean carpetaCreada = carpetaTemporal.mkdir();
            if (carpetaCreada) {
                System.out.println("Carpeta Temporal creada en el escritorio.");
            } else {
                System.out.println("No se pudo crear la carpeta Temporal.");
            }
        } else {
            System.out.println("La carpeta Temporal ya existe en el escritorio.");
        }

    }

}
