package RepasoExamen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Estadio {
    static class Marcador {
        private int total = 0;

        public synchronized void sumar(int entradas) {
            total += entradas;
        }

        public synchronized int getTotal() {
            return total;
        }
    }

    static class Torno implements Runnable {
        private final Marcador marcador;
        private int entradas;

        public Torno(Marcador marcador) {
            this.marcador = marcador;
        }

        public int getEntradas() {
            return entradas;
        }

        public void run() {
            entradas = ThreadLocalRandom.current().nextInt(500, 1001);
            marcador.sumar(entradas);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int NUM_TORNOS = 4;
        Marcador marcador = new Marcador();

        List<Torno> tornos = new ArrayList<>();
        List<Thread> hilos = new ArrayList<>();

        // 1) Lanzar TODOS los hilos
        for (int i = 1; i <= NUM_TORNOS; i++) {
            Torno torno = new Torno(marcador);
            Thread hilo = new Thread(torno, "Torno-" + i);
            tornos.add(torno);
            hilos.add(hilo);
            hilo.start();
        }

        // 2) Esperar a TODOS (bucle aparte)
        for (Thread hilo : hilos) {
            hilo.join();
        }

        // 3) Mostrar resultados (trabajo del main)
        int suma = 0;
        for (int i = 0; i < NUM_TORNOS; i++) {
            int entradas = tornos.get(i).getEntradas();
            System.out.println(hilos.get(i).getName() + ": " + entradas + " entradas");
            suma += entradas;
        }
        System.out.println("Marcador del estadio: " + marcador.getTotal());
        System.out.println("Suma de los tornos: " + suma);
        System.out.println(marcador.getTotal() == suma ? "Coinciden" : "NO coinciden");
    }
}