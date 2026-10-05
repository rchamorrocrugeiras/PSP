package Tarea9;

public class Descarga extends Thread {

    private static final int AJUSTE_BLOQUE = 1;

    private String nombreArchivo;
    private int tiempoBloque;

    public Descarga(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.tiempoBloque = (int) (Math.random() * 401) + 100;
    }
}
