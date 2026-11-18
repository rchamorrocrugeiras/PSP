package EstructuraAntiguoExamen;

import java.util.Random;

public class Ejercicio1 {

    // TODO: CAMBIAR SEGÚN ENUNCIADO
    private static final int NUM_ITERACIONES = 8; // Ej: 8 iteraciones[cite: 2]
    private static final int TIEMPO_MAX_MS = 500; // Tiempo aleatorio breve en ms[cite: 2]

    public static void main(String[] args) {
        // 1. Crear los hilos (si son muchos, usa un array Thread[] hilos = new Thread[N])
        // TODO: CAMBIAR NOMBRES/CANTIDAD SEGUN ENUNCIADO[cite: 2]
        HiloSecuencial h1 = new HiloSecuencial("Hilo 1");
        HiloSecuencial h2 = new HiloSecuencial("Hilo 2");
        HiloSecuencial h3 = new HiloSecuencial("Hilo 3");

        try {
            // 2. CONTROL DEL ORDEN DE EJECUCIÓN
            // El metodo .join() bloquea el hilo actual (main) hasta que el hilo llamado termine.

            // CASO A: Orden inverso (primero el 3, luego el 2, luego el 1)[cite: 2]
            h3.start();
            h3.join(); // Espera a que h3 acabe antes de arrancar h2[cite: 2]

            h2.start();
            h2.join(); // Espera a que h2 acabe antes de arrancar h1[cite: 2]

            h1.start();
            h1.join(); // Espera a que h1 acabe antes de terminar el main[cite: 2]

            /* CASO B: Si te piden orden normal (1, 2, 3), solo cambia el orden de start() y join()
            h1.start(); h1.join();
            h2.start(); h2.join();
            h3.start(); h3.join();
            */

        } catch (InterruptedException e) {
            System.err.println("Hilo interrumpido: " + e.getMessage());
        }

        // 3. Mensaje final del hilo principal[cite: 2]
        System.out.println("Programa principal terminado.");
    }

    static class HiloSecuencial extends Thread {
        private final Random random = new Random();

        public HiloSecuencial(String nombre) {
            super(nombre); // Asigna el nombre al hilo
        }

        @Override
        public void run() {
            for (int i = 1; i <= NUM_ITERACIONES; i++) {
                // TODO: ADAPTAR FORMATO DE SALIDA AL EJEMPLO DEL EXAMEN[cite: 2]
                System.out.println("Soy el " + getName() + " iteración: " + i);

                try {
                    // Bloqueo durante tiempo aleatorio breve[cite: 2]
                    int tiempoEspera = random.nextInt(TIEMPO_MAX_MS) + 50;
                    Thread.sleep(tiempoEspera);
                } catch (InterruptedException e) {
                    System.err.println("Error en sleep de " + getName());
                }
            }
        }
    }
}