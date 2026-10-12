package Tarea9b;

public class Alquimista {

    public static void main(String[] args) {

        //Crea las cuatro pociones
        Pocion p1 = new Pocion("aprobado");
        Pocion p2 = new Pocion("honestidad");
        Pocion p3 = new Pocion("esfuerzo");
        Pocion p4 = new Pocion("trabajo");

        //Guarda las pociones en un array
        Pocion[] pociones = {p1, p2, p3, p4};

        //Crea un hilo para cada pción
        Thread[] calderos = {
                new Thread(p1),
                new Thread(p2),
                new Thread(p3),
                new Thread(p4)
        };

        //Le da a cada hilo el nombre de su poción
        for (int i = 0; i < calderos.length; i++) {
            calderos[i].setName(pociones[i].getNombre());
        }

        //Se imprime antes de arrancar, ningún hilo está activo
        System.out.println("[Alquimista] Calderos al fuego: " + contarCalderos(calderos));

        long inicio = System.currentTimeMillis();

        //Se arrancan los hilos para inciar las cuatro pociones a la vez
        for (Thread caldero : calderos) {
            caldero.start();
        }

        //Se imprime cuantos hilos siguen activos después de iniciarlos
        System.out.println("[Alquimista] Calderos al fuego: " + contarCalderos(calderos));

        //Se espera a que terminen las cuatro pociones antes de mostrar el informe final
        for (Thread caldero : calderos) {
            try {
                caldero.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Alquimista] Proceso interrumpido.");
                return;
            }
        }

        //Se guarda el instante final de cuando han finalizado todas las pociones
        long fin = System.currentTimeMillis();

        //Se imprime la comprobación de que ningún hilo quede activo
        System.out.println("[Alquimista] Calderos al fuego: " + contarCalderos(calderos));
        long sumaTiempos = 0;

        //Inicialmente se guarda la primera poción como la mas lenta
        Pocion masLenta = pociones[0];

        //Se recorren las pociones para comparar sus tiempos y encontrar la más lenta
        for (Pocion pocion : pociones) {
            sumaTiempos += pocion.getTiempoTotal();

            if (pocion.getTiempoTotal() > masLenta.getTiempoTotal()) {
                masLenta = pocion;
            }
        }

        //Se imprime el informe final
        System.out.println("Todas las pociones están listas.");
        System.out.println("Tiempo real: " + (fin - inicio) + " ms");
        System.out.println("Una detrás de otra: " + sumaTiempos + " ms");
        System.out.println("La más lenta: " + masLenta.getNombre() + " (" + masLenta.getTiempoTotal() + " ms)");
    }

    //Cuenta los hilos que siguen ejecutándose utilizando isAlive().
    public static int contarCalderos(Thread[] calderos) {
        int contador = 0;

        for (Thread caldero : calderos) {
            if (caldero.isAlive()) {
                contador++;
            }
        }

        return contador;
    }
}