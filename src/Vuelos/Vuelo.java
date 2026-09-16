package Vuelos;

public class Vuelo {

    String codigo;
    String ciudad;
    String pais;
    String hora;
    String duracion;

    // arreglo de 20 puestos, uno para cada vuelo
    Puesto[] puestos = new Puesto[20];

    public Vuelo(String codigo, String ciudad, String pais, String hora, String duracion) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.hora = hora;
        this.duracion = duracion;

        for (int i = 0; i < 20; i++) {
            puestos[i] = new Puesto(i + 1);
        }
    }

    public int ocupados() {
        int cont = 0;
        for (int i = 0; i < 20; i++) {
            if (puestos[i].ocupado) {
                cont = cont + 1;
            }
        }
        return cont;
    }

    public int disponibles() {
        return 20 - ocupados();
    }

    public void mostrarPuestos() {
        for (int i = 0; i < 20; i++) {
            System.out.print(puestos[i].numero + "[" + puestos[i].estado() + "]   ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public void mostrarDatos() {
        System.out.println("Vuelo: " + codigo);
        System.out.println("Destino: " + ciudad + " (" + pais + ")");
        System.out.println("Hora de salida: " + hora);
        System.out.println("Duracion: " + duracion);
    }
}