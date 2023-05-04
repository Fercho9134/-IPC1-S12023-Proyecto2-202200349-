    package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

    public class ListaUsuarios extends EstructuraDeDatos {

        private Nodo cabeza;
        private static int contador = 0;

        public ListaUsuarios() {
            this.cabeza = null;
        }

        @Override
        public void add(Object usuario) {
            //creando nodo
            Nodo nuevo = new Nodo(usuario, contador);

            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Nodo auxiliar = cabeza;
                while (true) {
                    if (auxiliar.siguiente == null) {
                        auxiliar.siguiente = nuevo;
                        break;
                    } else {
                        auxiliar = auxiliar.siguiente;
                    }
                }
            }
            contador++;
        }

        //devuelve el ultimo elemento
        @Override
        public Object peek() {
            Nodo auxiliar = cabeza;
            if (cabeza != null) {
                return auxiliar;
            } else {
                return null;
            }
        }

        @Override
        public Object find(Object usuario) {
           //No se requiere
           return null;
        }
        
        public Usuario find(String nombre){
            Nodo auxiliar = cabeza;
            while(auxiliar != null){
                if(((Usuario) auxiliar.getUsuario()).getNombreUsuario().equals(nombre)){
                    return (Usuario) auxiliar.getUsuario();
                }else{
                    auxiliar = auxiliar.siguiente;
                }
            }
            return null;
        }


        @Override
        public Object getNext() {
            //No se requiere
            return null;

        }

        @Override
        public int getSize() {

            return contador;

        }

        @Override
        public Object get(int codigoUsuario) {
            Nodo auxiliar = cabeza;
            while (auxiliar != null) {
                if (auxiliar.getIndice() == codigoUsuario) {
                    return auxiliar.getUsuario();
                }
                auxiliar = auxiliar.siguiente;
            }
            return null;
        }

        @Override
        public Object pop() {
            //no se requiere
            return null;

        }

        @Override
    public void delete(Object usuario) {
        Usuario usuarioEliminar = (Usuario) usuario;
        Nodo anterior = null;
        Nodo actual = cabeza;
        while (actual != null) {            
            if (actual.getIndice() == usuarioEliminar.getIndiceUsuario()) {
                if (anterior == null) { // caso especial para la cabeza
                    cabeza = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                actual.siguiente = null; // elimina la referencia al siguiente nodo
                return; // sale del método después de eliminar el nodo
            } else {
                anterior = actual;
                actual = actual.siguiente;
            }
        }
    }

    public void imprimir(){
        Nodo auxiliar=cabeza;
        while(auxiliar != null){
            System.out.println("Usuario " + ((Usuario) auxiliar.getUsuario()).getIndiceUsuario() +  " Nombre: " + ((Usuario) auxiliar.getUsuario()).getNombreUsuario());
            auxiliar = auxiliar.siguiente;
        }

    }

    // método para serializar la lista de usuarios
    public void serializar() throws IOException {
        FileOutputStream archivoSalida = new FileOutputStream("usuarios.dat");
        ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
        objetoSalida.writeObject(this);
        objetoSalida.close();
    }

    public void cargarSerializacion() {
    try {
        FileInputStream archivo = new FileInputStream("usuarios.dat");
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        ListaUsuarios listaSerializada = (ListaUsuarios) entrada.readObject();
        entrada.close();
        archivo.close();

        Nodo auxiliar = listaSerializada.cabeza;
        while (auxiliar != null) {
            add(auxiliar.getUsuario());
            auxiliar = auxiliar.siguiente;
        }

    } catch (IOException ex) {
        System.out.println("Error al cargar la lista serializada");
        ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
        System.out.println("No se encontró la clase ListaUsuarios");
        ex.printStackTrace();
    }
}
}
    
    
