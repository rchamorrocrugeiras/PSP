package RepasoExamen;

import java.util.Random;

public class Tornos extends Thread {
    private String nombre;
    private int numero;
    private static int compartido = 0;
    private Random aleatorio = new Random();

    public Tornos(String nombre) {
        this.nombre = nombre;
    }

    public static synchronized void sumarEntradas(int cantidad) {
        compartido += cantidad;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        numero = aleatorio.nextInt(501) + 500;
        sumarEntradas(numero);
        System.out.println(nombre + ": " + numero + " entradas");
    }

    public static int getContador() {
        return compartido;
    }

    public static void main(String[] args) {
        Tornos[] tornos = {
                new Tornos("Torno-1"),
                new Tornos("Torno-2"),
                new Tornos("Torno-3"),
                new Tornos("Torno-4")
        };

        for (Tornos torno : tornos) {
            torno.start();
        }

        try {
            for (Tornos torno : tornos) {
                torno.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Error en la ejecución de los hilos: " + e.getMessage());
        }

        int sumaTornos = 0;
        for (Tornos torno : tornos) {
            sumaTornos += torno.getNumero();
        }

        int marcadorEstadio = Tornos.getContador();

        System.out.println("Marcador del estadio: " + marcadorEstadio);
        System.out.println("Suma de los tornos: " + sumaTornos);

        if (marcadorEstadio == sumaTornos) {
            System.out.println("✓ Comprobación correcta: Los totales coinciden.");
        } else {
            System.out.println("✗ Error de sincronización: Los totales no coinciden.");
        }
    }
}