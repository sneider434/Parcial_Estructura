package Vuelos;

public class ListaVuelos {

    NodoVuelo primero;
    int cantidad;

    public ListaVuelos() {
        primero = null;
        cantidad = 0;
    }

    public void agregar(Vuelo v) {
        NodoVuelo nuevo = new NodoVuelo(v);

        if (primero == null) {
            primero = nuevo;
        } else {
            NodoVuelo aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        cantidad = cantidad + 1;
    }

    public boolean existe(String codigo) {
        NodoVuelo aux = primero;
        while (aux != null) {
            if (aux.vuelo.codigo.equalsIgnoreCase(codigo)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public Vuelo obtener(int pos) {
        NodoVuelo aux = primero;
        int i = 0;
        while (aux != null) {
            if (i == pos) {
                return aux.vuelo;
            }
            i = i + 1;
            aux = aux.siguiente;
        }
        return null;
    }

    public void mostrarLista() {
        NodoVuelo aux = primero;
        int i = 1;
        while (aux != null) {
            System.out.println(i + ". " + aux.vuelo.codigo + " - " + aux.vuelo.ciudad);
            i = i + 1;
            aux = aux.siguiente;
        }
    }
}