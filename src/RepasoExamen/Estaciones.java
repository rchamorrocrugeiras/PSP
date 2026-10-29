package RepasoExamen;

public class Estaciones extends Thread {
    public String nombre;

    // Hacemos e1 y e2 estáticos para consultarlos desde el run() de Pintura
    public static Estaciones e1;
    public static Estaciones e2;

    public Estaciones(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // Si es Pintura, se espera a que terminen e1 y e2 antes de empezar sus pasos
            if (nombre.equals("Pintura")) {
                e1.join();
                e2.join();
            }

            for (int i = 1; i <= 5; i++) {
                Thread.sleep(500);
                System.out.println(nombre + " - " + "paso " + i);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String [] args) {
        e1 = new Estaciones("Ensamblaje");
        e2 = new Estaciones("Corte");
        Estaciones e3 = new Estaciones("Pintura");

        try {
            e1.start();
            e2.start();
            e3.start(); // Se arrancan las 3 a la vez
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            e3.join(); // Solo hace falta esperar a e3, ya que e3 espera a las otras dos
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}