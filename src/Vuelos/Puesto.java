package Vuelos;

public class Puesto {

    int numero;
    boolean ocupado;
    String nombre;
    String documento;

    public Puesto(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.nombre = "";
        this.documento = "";
    }

    public void ocupar(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
        this.ocupado = true;
    }

    public String estado() {
        if (ocupado) {
            return "O";
        } else {
            return "D";
        }
    }
}