package Tarea9b;

import java.util.Random;

public class Pocion implements Runnable {

    private String nombre;
    private int fases;
    private int duracionFase;
    private long tiempoTotal;

    public Pocion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTiempoTotal() {
        return tiempoTotal;
    }
}
