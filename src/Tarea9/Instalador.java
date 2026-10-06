package Tarea9;

public class Instalador implements Runnable {

    private Descarga meditacion;
    private Descarga mantras;

    public Instalador(Descarga meditacion, Descarga mantras) {
        this.meditacion = meditacion;
        this.mantras = mantras;
    }

    public void run() {
        try {
            meditacion.join();
            mantras.join();
        } catch (InterruptedException e) {
            return;
        }

        System.out.println("Instalación completada.");
    }
}