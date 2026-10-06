package Tarea9;

public class Descarga extends Thread {

    private static final int AJUSTE_BLOQUE = 1;

    private String nombreArchivo;
    private int tiempoBloque;
    private long tiempoDescarga;

    public Descarga(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.tiempoBloque = (int) (Math.random() * 401) + 100;
    }

    public void run() {
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(tiempoBloque * AJUSTE_BLOQUE);
            } catch (InterruptedException e) {
                return;
            }

            System.out.println("[" + nombreArchivo + "] " + (i * 10) + "%");
        }

        tiempoDescarga = System.currentTimeMillis() - inicio;

        System.out.println("[" + nombreArchivo + "] completada en "
                + tiempoDescarga + " ms");
    }

    public long getTiempoDescarga() {
        return tiempoDescarga;
    }
}