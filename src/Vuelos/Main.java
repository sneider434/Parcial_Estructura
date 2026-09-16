package Vuelos;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ListaVuelos lista = new ListaVuelos();

    public static void main(String[] args) {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println();
            System.out.println("========== AEROPUERTO ==========");
            System.out.println("1. Registrar vuelo");
            System.out.println("2. Asignar puesto");
            System.out.println("3. Iniciar abordaje");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                registrarVuelo();
            } else if (opcion == 2) {
                asignarPuesto();
            } else if (opcion == 3) {
                iniciarAbordaje();
            } else if (opcion == 0) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion invalida");
            }
        }
    }

    public static void registrarVuelo() {

        System.out.println();
        System.out.println("===== REGISTRAR VUELO =====");

        System.out.print("Codigo del vuelo: ");
        String codigo = sc.nextLine();

        while (lista.existe(codigo)) {
            System.out.println("Ese codigo ya existe");
            System.out.print("Codigo del vuelo: ");
            codigo = sc.nextLine();
        }

        System.out.print("Ciudad de destino: ");
        String ciudad = sc.nextLine();

        System.out.print("Pais de destino: ");
        String pais = sc.nextLine();

        System.out.print("Hora de salida: ");
        String hora = sc.nextLine();

        System.out.print("Duracion estimada: ");
        String duracion = sc.nextLine();

        Vuelo v = new Vuelo(codigo, ciudad, pais, hora, duracion);
        lista.agregar(v);

        System.out.println("Vuelo registrado");
    }

    public static void asignarPuesto() {

        if (lista.cantidad == 0) {
            System.out.println("No hay vuelos registrados");
            return;
        }

        System.out.println();
        System.out.println("========== VUELOS ==========");
        System.out.println();
        lista.mostrarLista();
        System.out.println();
        System.out.print("Seleccione un vuelo: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > lista.cantidad) {
            System.out.println("Vuelo invalido");
            return;
        }

        Vuelo v = lista.obtener(op - 1);

        int puesto = 0;

        while (puesto != -1) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("          VUELO SELECCIONADO");
            System.out.println("====================================");
            System.out.println();
            v.mostrarDatos();
            System.out.println();
            System.out.println("Puestos:");
            System.out.println();
            v.mostrarPuestos();
            System.out.println("D = Disponible");
            System.out.println("O = Ocupado");
            System.out.println("====================================");
            System.out.println();

            System.out.print("Numero de puesto (-1 para volver al menu): ");
            puesto = sc.nextInt();
            sc.nextLine();

            if (puesto == -1) {
                return;
            }

            if (puesto < 1 || puesto > 20) {
                System.out.println("El puesto debe estar entre 1 y 20");
            } else if (v.puestos[puesto - 1].ocupado) {
                System.out.println("El puesto " + puesto + " no esta disponible, escoja otro");
            } else {
                System.out.print("Nombre del pasajero: ");
                String nombre = sc.nextLine();

                System.out.print("Documento: ");
                String documento = sc.nextLine();

                v.puestos[puesto - 1].ocupar(nombre, documento);

                System.out.println("Puesto " + puesto + " asignado a " + nombre);
            }
        }
    }

    public static void iniciarAbordaje() {

        if (lista.cantidad == 0) {
            System.out.println("No hay vuelos registrados");
            return;
        }

        NodoVuelo aux = lista.primero;

        while (aux != null) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("          VUELO ACTUAL");
            System.out.println("====================================");
            System.out.println();
            aux.vuelo.mostrarDatos();
            System.out.println();
            System.out.println("Puestos ocupados: " + aux.vuelo.ocupados());
            System.out.println("Puestos disponibles: " + aux.vuelo.disponibles());
            System.out.println();

            aux = aux.siguiente;

            if (aux != null) {
                System.out.print("Presione una tecla para continuar...");
                sc.nextLine();
            }
        }

        System.out.println();
        System.out.println("Todos los vuelos fueron procesados");
        System.out.println("Fin del programa");
        System.exit(0);
    }
}