package Vuelos;
public class NodoVuelo {

    Vuelo vuelo;
    NodoVuelo siguiente;

    public NodoVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.siguiente = null;
    }
}