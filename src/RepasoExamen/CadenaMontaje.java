package RepasoExamen;

public class CadenaMontaje {
    static class Estacion implements Runnable {
        private final String nombre;
        private final Thread[] dependencias; // hilos que deben terminar antes

        public Estacion(String nombre, Thread... dependencias) {
            this.nombre = nombre;
            this.dependencias = dependencias;
        }

        public void run() {
            try {
                // Espera a las estaciones de las que depende (si las hay)
                for (Thread dependencia : dependencias) {
                    dependencia.join();
                }
                for (int paso = 1; paso <= 5; paso++) {
                    System.out.println(nombre + " - paso " + paso);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread corte = new Thread(new Estacion("Corte"));
        Thread ensamblaje = new Thread(new Estacion("Ensamblaje"));
        Thread pintura = new Thread(new Estacion("Pintura", corte, ensamblaje));

        // Se arrancan las tres a la vez; Pintura se bloquea en join() hasta que acaben las otras
        corte.start();
        ensamblaje.start();
        pintura.start();

        pintura.join();
        System.out.println("Producto terminado.");
    }
}