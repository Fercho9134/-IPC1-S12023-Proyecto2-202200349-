package Clases;

public class ListaImagenes extends EstructuraDeDatos {

    private NodoDoble inicio, fin;
    private int contador = 0;
    private int codigo = 0;

    public ListaImagenes() {
        this.inicio = this.fin = null;
    }

    @Override
    public void add(Object imagen) {
        //Si la lista está vacia
        if (inicio == null) {
            inicio = fin = new NodoDoble(imagen, codigo, null, null);
            contador++;
            codigo++;
        } else {
            NodoDoble auxiliar = new NodoDoble(imagen, codigo, null, fin);
            fin.siguiente = auxiliar;
            auxiliar.anterior = fin;
            fin = auxiliar;
            contador++;
            codigo++;
        }
    }

    @Override
    public Object peek() {
        if (inicio != null) {
            return inicio;
        } else {
            return null;
        }
    }

    @Override
    public Object find(Object e) {
        return null;
    }

    public Imagen find(String nombre) {
        NodoDoble auxiliar = inicio;

        while (auxiliar != null) {

            if (((Imagen) auxiliar.getImagen()).getNombre().equals(nombre)) {
                return (Imagen) auxiliar.getImagen();
            } else {
                auxiliar = auxiliar.siguiente;
            }

        }
        return null;
    }

    public NodoDoble findNode(String nombre) {
        NodoDoble auxiliar = inicio;

        while (auxiliar != null) {

            if (((Imagen) auxiliar.getImagen()).getNombre().equals(nombre)) {
                return auxiliar;
            } else {
                auxiliar = auxiliar.siguiente;
            }

        }
        return null;
    }

    @Override
    public Object getNext() {
        return null;
    }

    public NodoDoble getNext(NodoDoble nodo) {
        return nodo.siguiente;
    }

    public NodoDoble getPrev(NodoDoble nodo) {
        return nodo.anterior;
    }

    @Override
    public int getSize() {
        return contador;
    }

    @Override
    public Object get(int codigo) {
        NodoDoble auxiliar = inicio;
        while (auxiliar != null) {
            if (auxiliar.getIndice() == codigo) {
                return auxiliar.getImagen();
            }
            auxiliar = auxiliar.siguiente;
        }
        return null;
    }
    

    @Override
    public Object pop() {
        if (fin == null) {
            return null; // lista vacía, no se puede eliminar
        } else if (inicio == fin) {
            // la lista solo tiene un elemento
            Object imagen = fin.getImagen();
            inicio = fin = null;
            return imagen;
        } else {
            // la lista tiene más de un elemento
            Object imagen = fin.getImagen();
            fin = fin.anterior;
            fin.siguiente = null;
            return imagen;
        }
    }

    @Override
    public void delete(Object nodo) {
        NodoDoble eliminando = (NodoDoble) nodo;
        NodoDoble anterior = null;
        NodoDoble siguiente = inicio.siguiente;
        NodoDoble actual = inicio;

        while (actual != null) {
            if (actual.getIndice() == eliminando.getIndice()) {
                if (anterior == null) { // caso especial para la cabeza
                    inicio = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                    System.out.println("Llego aqui");
                }
                if (actual.siguiente == null) { // caso especial para la cola
                    fin = anterior;
                } else {
                    actual.siguiente.anterior = anterior;
                }
                actual.siguiente = null; // elimina la referencia al siguiente nodo
                actual.anterior = null; // elimina la referencia al nodo anterior
                contador--;
                return; // sale del método después de eliminar el nodo
            } else {
                anterior = actual;
                actual = actual.siguiente;
                if (actual != null) {
                    siguiente = actual.siguiente;
                }
            }
        }
    }

}
